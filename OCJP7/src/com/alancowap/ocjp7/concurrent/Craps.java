/**
 * Simple class to demonstrate Java concurrency and classes/interfaces from java.util.concurrent 
 *  - ExecutorService, Callable, Future, Executors, ThreadLocalRandom
 *  
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Craps {
	public static void main(String[] args){
		System.out.println("Welcome to Casino Cowap, no gambling allowed we're only interested in statistics and Java concurrency :)");
		Callable <Integer> di = new Di();
		ExecutorService player = Executors.newFixedThreadPool(2);
		Future<Integer> rollResult = player.submit(di);
		int result = 0;
		try{
			result = rollResult.get(); //The get() method of Future will block until it's finished
		}catch(InterruptedException | ExecutionException iex){
			System.out.println("Oops, something unexpected happened!");
		}
		System.out.println("You rolled " + result);
		
		player.shutdown(); //complete existing tasks, but don't accept new tasks	
		
	}
	
}
