/**
 * 
 */
package com.alancowap.ocjp7.designpatterns;

import java.util.Set;
import java.util.HashSet;

/**
 * Singleton Design Pattern using an Enum (available since Java 5)
 * This example keeps track of the available ports on an IP address.
 * So we want a single instance of our Ports.
 * Note this a simple example and is not thread-safe.
 * Code based on Sierra & Bates book
 * 
 * @author Alan Cowap
 *
 */
public enum PortEnum {
	INSTANCE;
	
	private Set<Integer> availablePorts;	//keep this private to prevent direct access
	private PortEnum(){
		//TODO !!!
		availablePorts = new HashSet<Integer>();
		availablePorts.add(5060);
		availablePorts.add(5061);		
	}
	
	public boolean acquirePort(Integer portNumber){
		return availablePorts.remove(portNumber);
	}
	
}

/**
 * Simple class to represent a Port on an IP address
 */
class Port{
	int mPortNumber;
	public Port(int portNumber){
		mPortNumber = portNumber;
	}
	
	//TODO Implement hashCode and equals
	
}