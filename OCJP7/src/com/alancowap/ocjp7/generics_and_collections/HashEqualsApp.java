/**
 * Demo overriding of toString, equals, hashCode.
 * Use ArrayList, HashSet
 * 
 * @author Alan Cowap
 * 
 */
package com.alancowap.ocjp7.generics_and_collections;

import java.util.ArrayList;
import java.util.HashSet;

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
		System.out.println("~~~ HashSet ~~~");
		HashSet<IPAddress> hashSet = new HashSet<IPAddress>(2);
		System.out.println(hashSet.add(ip));	//true
		System.out.println(hashSet.add(ip));	//false
		System.out.println(hashSet.add(ip2));	//false
		System.out.println(hashSet.add(ip2));	//false
		IPAddress ip3 = new IPAddress("10.0.0.2");
		System.out.println(hashSet.add(ip3));	//true
		
		//HashCode Contract: 3 Rules
		//1. Consistent hashCode. 381...
		for(int i = 0; i <10; ++i)
			System.out.print(ip3.hashCode() + " ");
		
		//2. if equals returns true, hashCode must be equal
		for(IPAddress ipAddy : hashSet)  
			System.out.print("\n"+ ipAddy.equals(ip) +" "+ (ipAddy.hashCode() == ip.hashCode()));
		
		//3. if hashCodes are equal, equals does not have to return true (same bucket, different objects) 
		//TODO Exercise: Modify the equals method to check the portNumber for equality
		//TODO - see how this changes the results.
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
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof IPAddress &&
				(((IPAddress) obj).ipAddress == this.ipAddress ) && 
				(((IPAddress) obj).portNumber == this.portNumber )
				);
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		for(char ch : ipAddress.toCharArray()){
			hashCode += ch;
		}		
		return hashCode;
	}
	
	
	
}
