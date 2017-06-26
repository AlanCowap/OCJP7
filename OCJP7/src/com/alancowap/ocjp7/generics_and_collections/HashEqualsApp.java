/**
 * Demo overriding of toString, equals, hashCode/
 * 
 */
package com.alancowap.ocjp7.generics_and_collections;

import java.util.ArrayList;

public class HashEqualsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Equals & HashCode");
		IPAddress ip = new IPAddress("127.0.0.1");
		
		//toString()
		//Before overriding toString(): com.alancowap.ocjp7.generics_and_collections.IPAddress@15db9742
		//After overriding toString(): 127.0.0.1:-1
		System.out.println(ip); 

		//equals() - Use case: Determine if two IPAddress objects are the same
		IPAddress ip2 = new IPAddress("127.0.0.1");
		System.out.println("ip == ip2 " + (ip == ip2)); //object equality (memory addresses)
		System.out.println("ip.equals(ip2) " + ip.equals(ip2)); //meaningful equivalence or == ?
		//we need to override equals(), because Objects implementation is simply == 
		
		//Let's look at an example of the Collection classes using equals
		ArrayList<IPAddress> al = new ArrayList<IPAddress>(2);
		System.out.println(!al.contains(ip));	//true
		if(!al.contains(ip)) al.add(ip);	
		
		System.out.println(!al.contains(ip));	//false
		if(!al.contains(ip)) al.add(ip);
		
		System.out.println(!al.contains(ip2));	//false
		if(!al.contains(ip2)) al.add(ip2);
		
		System.out.println(!al.contains(ip2));	//false
		//Wouldn't it be great if the Collection Framework provided a class that checked for duplicates, hmm!
		
		
	}
	
}




class IPAddress{
	private String ipAddress;
	private int portNumber;
	private static final int DEFAULT_PORT_NUMBER = -1;

	public IPAddress(String ipAddress) {
		this(ipAddress, DEFAULT_PORT_NUMBER);
	}
	
	public IPAddress(String ipAddress, int portNumber) {
		super();
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public String getIPaddress() {
		return ipAddress;
	}
	public void setIPaddress(String iPaddress) {
		this.ipAddress = iPaddress;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	@Override
	public String toString() {
		return this.ipAddress + ':' + this.portNumber;
	}

	public boolean equals(Object obj) {
		return (obj instanceof IPAddress && (((IPAddress) obj).ipAddress == this.ipAddress ));
	}
	
	
	
}
