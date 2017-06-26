/**
 * Demo overriding of toString, equals, hashCode/
 * 
 */
package com.alancowap.ocjp7.generics_and_collections;

public class HashEqualsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Equals & HashCode");
		IPAddress ip = new IPAddress("127.0.0.1");
		System.out.println(ip);

	}
	
}




class IPAddress{
	private String IPaddress;

	public IPAddress(String iPaddress) {
		super();
		IPaddress = iPaddress;
	}

	public String getIPaddress() {
		return IPaddress;
	}

	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}

	
	
}
