/**
 * Demo use of Singleton Design pattern
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.designpatterns;

public class SingletonApp {
	public static void main(String[] args) {
		System.out.println("Demo of Singleton Design Pattern");
		PortReserver.reservePort(5060);	//Ok
		PortReserver.reservePort(5060);	//Oops, this should be blocked, port is already reserved
		PortReserver.reservePort(5061);	//Ok
		System.out.println("Return port 5060");
		PortReserver.returnPort(5060);	//Ok
		PortReserver.reservePort(5060);	//Ok
	}
}

//Does this class look like it's part of a DAO Pattern?
class PortReserver{
	public static void reservePort(int portNumber){
		PortEnum ports = PortEnum.INSTANCE;	//get our singleton
		System.out.println(ports.acquirePort(portNumber));
	}
	
	public static void returnPort(int portNumber){
		PortEnum ports = PortEnum.INSTANCE;	//get our singleton
		System.out.println(ports.returnPort(portNumber));
	}
	//TODO overload the reservePort method to take a Port as parameter
	//TODO overload the returnPort method to take a Port as parameter
}