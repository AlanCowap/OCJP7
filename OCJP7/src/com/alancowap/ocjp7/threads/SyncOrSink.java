/**
 * Simple class to demonstrate concurrent access problem: "dirty read"
 * @ref https://en.wikipedia.org/wiki/Isolation_(database_systems)#Dirty_reads
 * - and solution using a "synchronized" method
 * 
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.threads;

public class SyncOrSink implements Runnable{

	private Submarine yellowSubmarine = new Submarine(40);
	
	public static void main(String[] args) {
		System.out.println("Welcome to SyncOrSwim");
		SyncOrSink sos = new SyncOrSink();
		Thread tweedleDum = new Thread(sos);
		tweedleDum.setName("TweedleDum");
		Thread tweedleDee = new Thread(sos);
		tweedleDee.setName("TweedleDee");
		tweedleDum.start();
		tweedleDee.start();
	}

	@Override
	public void run() {
		for(int i=0; i<5; ++i){
			yellowSubmarine.dive(10);
			if(0 >= yellowSubmarine.getMetersToBottom()){
				System.out.printf("\nI'm sorry %s, the submarine hit the sea-bed, say Hi to Davy Jones locker!\n", Thread.currentThread().getName());
				break;
			}
		}
	}	

}

class Submarine{
	private int metersToBottom = 0;
	
	public Submarine(int metersToBottom) {
		this.metersToBottom = metersToBottom;
	}

	public int getMetersToBottom() {
		return this.metersToBottom;
	}

//	public void setMetersToBottom(int metersToBottom) {
//		this.metersToBottom = metersToBottom;
//	}

	public void dive(int metersToDescend){
//	public synchronized void dive(int metersToDescend){	//making the check and the update atomic will prevent this "dirty read" issue. @ref https://en.wikipedia.org/wiki/Isolation_(database_systems)#Dirty_reads
		//we don't want to impact the sea-bed ;)
		if (metersToDescend < this.getMetersToBottom()){
			System.out.println(Thread.currentThread().getName() + " Descending " + metersToDescend + ". Distance to bottom " + this.getMetersToBottom());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} //stall the ball
			this.metersToBottom -= metersToDescend;
		}else{
			System.out.printf("\n%s Distance to sea-bed is %d. I can't dive %d", Thread.currentThread().getName(), this.metersToBottom, metersToDescend);
		}
	}
}

/* Sample Output:

Welcome to SyncOrSwim
TweedleDum Descending 10. Distance to bottom 40
TweedleDee Descending 10. Distance to bottom 40
TweedleDee Descending 10. Distance to bottom 30
TweedleDum Descending 10. Distance to bottom 30
TweedleDee Descending 10. Distance to bottom 10

TweedleDum Distance to sea-bed is 10. I can't dive 10
TweedleDum Distance to sea-bed is 10. I can't dive 10
TweedleDum Distance to sea-bed is 10. I can't dive 10
I'm sorry TweedleDee, the submarine hit the sea-bed, say Hi to Davy Jones locker!

*/
