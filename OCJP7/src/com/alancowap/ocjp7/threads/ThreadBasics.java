/**
 * Simple class to demonstrate Threads - using Runnable.
 *  - adding state to our Runnable class
 *  - creating multiple Threads and multiple Runnables
 *  - does setting Priority change the Running order? Nope!
 *  - what about using sleep() to get one thread to finish reliably before others?
 *  - - depends where the sleep() goes, but it can be unreliable, and is very slow.
 *  - Thread.sleep is a static method, it puts the current Thread to sleep
 *  - - you can't put another Thread to sleep, so t2.sleep() puts you to sleep - not t2
 *  - Maybe Thread.yield() will do the trick for us? Nope, yield sends a RUNNING thread to RUNNABLE
 *  - Note the problem is these are the wrong tools to sequence/choreograph our Threads
 * 
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.threads;

public class ThreadBasics {
	public static void main(String[] args) {
		System.out.println("Thread Tester");
		NumberThread numberThread1 = new NumberThread(1, '\\');
		Thread t1 = new Thread(numberThread1);				
		NumberThread numberThread2 = new NumberThread(2, '|');
		Thread t2 = new Thread(numberThread2);		
		NumberThread numberThread3 = new NumberThread(3, '/');
		Thread t3 = new Thread(numberThread3);
		//Will setting Priority change the order of execution? Not reliably.
		//setPriority() isn't suitable for sequencing
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	
		t1.start();
		t2.start();
		t3.start();
		for (int i=0; i < 50; ++i){
			System.out.print(0);
			Thread.yield();
			System.out.print("-"); //Let's see when we yield
		}
	}
}

class NumberThread implements Runnable{
	private int mNumber;
	private char mSymbol;
	
	NumberThread(int number, char symbol){
		mNumber = number;
		mSymbol = symbol;
	}
	
	@Override
	public void run() {
		//Thread.sleep() isn't suitable for sequencing
//		try {
//			Thread.sleep(50 * mNumber);
//		} catch (InterruptedException e) {				
////			e.printStackTrace();
//		}
		for (int i=0; i < 50; ++i){
			System.out.print(mNumber);
			//Thread.yield() isn't suitable for sequencing
			Thread.yield();
			System.out.print(mSymbol); //Let's see when we yield
		}
	}

}
