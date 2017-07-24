/**
 * Simple class to demonstrate Threads - using Runnable.
 *  - using Anonymous inner class
 *  Notice how :
 *  - the output of the Threads (named A, B, C) can intermingle.
 *  - the output from the program tends to be different each time we run it
 *  - these are important factors to consider with Concurrency *  
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.threads;

public class MyFirstThread {

	public static void main(String[] args) {

		for(char name = 'A'; name < 'D'; ++name){
			new Thread(new Runnable(){
				@Override
				public void run() {
					String name = Thread.currentThread().getName();
					for(int i=0; i<100; ++i)
						System.out.print(name);
				}
			}, Character.toString(name)).start();
		}
	}

}
