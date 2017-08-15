/**
 * Simple class to demonstrate InterruptedException NOT thrown in normal usage of sleep, wait, join
 *  - InterruptedException not normally used in a sleep()
 *  - InterruptedException not normally used in a wait()
 *  - InterruptedException not normally used in a join()
 *  
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.threads;

public class NoInterruptions {

	public static void main(String[] args) {
		new NoInterruptions().doStuff();		
	}
	
	private void doStuff(){
		System.out.println("InterruptedException is not normally thrown by sleep(), join(), or wait()");
		final String interruptedMessage = "Who interrupted me?";
		
		//Sleep
		try {
			System.out.println("\nI'm going to take a nap");
			Thread.sleep(800);
		} catch (InterruptedException e) {
			System.out.println(interruptedMessage);
		}
		System.out.println("I'm awake again");
		
		//Join
		Thread joiner = new Thread(new Joiner());
		joiner.start();
		try {
			System.out.println("\nI'm going to join Joiner");
			joiner.join(800);
		} catch (InterruptedException e) {
			System.out.println(interruptedMessage);
		}
		System.out.println("I'm back from the join");
		
		//Wait
		Runnable notifier = new Notifier();
		Thread notice = new Thread(notifier);
		notice.start();
		synchronized(notifier){
			try {
				System.out.println("\nI shall wait to be notified");
				notifier.wait();	//should put wait() in a loop etc. in case we miss the corresponding notify()
				System.out.println("The wait is over");
			} catch (InterruptedException e) {
				System.out.println(interruptedMessage);
			}
			System.out.println("I am not even trying to wait");
		}		
	}
	
}

class Notifier implements Runnable{
	final String interruptedMessage = "-Who interrupted me?";
	@Override
	public void run() {
		System.out.println("-Note this");
		synchronized(this){
			System.out.println("-Note that");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(interruptedMessage);
			}
			notifyAll();
			System.out.println("-Noted");
		}		
	}	
}


class Joiner implements Runnable{
	final String interruptedMessage = "~Who interrupted me?";
	@Override
	public void run() {
		System.out.println("~Runing to the hills");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			System.out.println(interruptedMessage);
		}
	}	
}

/* Sample output YMMV
 * 
InterruptedException is not normally thrown by sleep(), join(), or wait()

I'm going to take a nap
I'm awake again

I'm going to join Joiner
~Runing to the hills
I'm back from the join

I shall wait to be notified
-Note this
-Note that
-Noted
The wait is over
I am not even trying to wait


*/
