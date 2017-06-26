/**
 * Demo overriding of toString, equals, hashCode/
 * 
 */
package com.alancowap.ocjp7.generics_and_collections;

public class HashEqualsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Equals & HashCode");
		IPAddress ip = new IPAddress("127.0.0.1");
		
		//toString()
		//Before overriding toString(): com.alancowap.ocjp7.generics_and_collections.IPAddress@15db9742
		//After overriding toString(): 127.0.0.1:-1
		System.out.println(ip); 

		//equals() - Use case: Determine if two IPAddress objects are the same
		

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
	
}
