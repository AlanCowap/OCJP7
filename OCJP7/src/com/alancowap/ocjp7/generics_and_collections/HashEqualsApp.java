/**
 * Demo overriding of toString, equals, hashCode/
 * 
 */
package com.alancowap.ocjp7.generics_and_collections;

public class HashEqualsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Equals & HashCode");
		IPAddress ip = new IPAddress("127.0.0.1");
		System.out.println(ip); // com.alancowap.ocjp7.generics_and_collections.IPAddress@15db9742


	}
	
}




class IPAddress{
	private String ipAddress;
	private int portNumber;

	public IPAddress(String ipAddress) {
		this(ipAddress, -1);
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

	
	
}
