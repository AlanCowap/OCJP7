/**
 * Singleton Design Pattern using an enum (available since Java 5)
 * This example keeps track of the available ports on an IP address.
 * So we want a single instance of our Ports.
 * Note this a simple example and is not thread-safe.
 * Code based on Sierra & Bates book
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.designpatterns;

import java.util.Set;
import java.util.HashSet;

/**
 * Create a Singleton using an enum
 */
public enum PortEnum {
	INSTANCE;
	
	//TODO Use the Port class (see below) rather than an Integer
	private Set<Integer> availablePorts;	//keep this private to prevent direct access
	private PortEnum(){						//keep this private to prevent instantiation, (Note: enum constructors can't be called directly)
		availablePorts = new HashSet<Integer>();
		availablePorts.add(5060);
		availablePorts.add(5061);		
	}	
	public boolean acquirePort(Integer portNumber){	//keep this public so people can get a ref to the singleton
		return availablePorts.remove(portNumber);
	}
	public boolean returnPort(Integer portNumber){
		return availablePorts.add(portNumber);
	}
}

/**
 * Simple class to represent a Port on an IP address
 * You could implement this (rather than use an Integer) however you should override hashCode and equals
 */
class Port{
	int mPortNumber;
	public Port(int portNumber){
		mPortNumber = portNumber;
	}
	
	//TODO Implement hashCode and equals
	
}