/**
 * Implementation of the Callable interface, representing the roll of a di
 *
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Di implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

}
