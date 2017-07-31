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

		NumberThread numberThread1 = new NumberThread(1);
		Thread t1 = new Thread(numberThread1);				
		NumberThread numberThread2 = new NumberThread(2);
		Thread t2 = new Thread(numberThread2);		
		NumberThread numberThread3 = new NumberThread(3);
		Thread t3 = new Thread(numberThread3);
		t1.start();
		t2.start();
		t3.start();
		for (int i=0; i < 50; ++i)
			System.out.print(0);
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
