/**
 * Simple class to demonstrate Threads - using Runnable.
 *  - adding state to our Runnable class
 *  - creating multiple Threads and multiple Runnables
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.threads;

public class ThreadBasics {
	public static void main(String[] args) {
		System.out.println("Thread Tester");
//		ThreadBasics app = new ThreadBasics();
		NumberThread numberThread = new NumberThread(2);
		Thread t1 = new Thread(numberThread);		
		t1.start();
	}
}

class NumberThread implements Runnable{
	private int mNumber;
	
	NumberThread(int number){
		mNumber = number;
	}
	
	@Override
	public void run() {
		for (int i=0; i < 50; ++i)
			System.out.print(mNumber);		
	}
	
}
