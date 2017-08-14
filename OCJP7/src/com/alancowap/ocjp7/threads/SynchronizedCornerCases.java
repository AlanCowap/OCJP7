/**
 * Simple class to demonstrate "synchronized" code corner cases. 
 *  - Can you synchronize on a primitive, enum, array?  
 *  - Can you have a synchronized block in a constructor? 
 *  - Can you have a synchronized constructor?
 *  - Can you synchronize on a String literal?
 *  - Can you synchronize on an Exception?
 *  
 * There are many reasons why you shouldn't use some of these,
 *  this code is just to demo some of what you can and cannot sync on
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.threads;

public class SynchronizedCornerCases {
	enum RockyPlanets {MERCURY, VENUS, EARTH, MARS};

	public static void main(String[] args) {
//		synchronized(5){}					//can't lock on a primitive
		synchronized(new Integer(5)){}		//can lock on an object
		synchronized(RockyPlanets.EARTH){};	//can lock on an enum
		synchronized(new int[]{1,2,3}){}	//can lock on an array (it's an object)
		synchronized(new IllegalMonitorStateException()){} //it's an object!
		
		synchronized("Hi"){}	//can lock on a String literal (it's an object)
		synchronized("Hi"){}	//Same lock as String above - String Constant Pool
		synchronized("Hi".concat("Java")){}	//New String in SCP	
		
		synchronized(""){}		//Empty String (in the String Constant Pool)
		synchronized(""+""){}	//Same lock as empty String above - String Constant Pool
		
		//Code to verify that an empty String literal goes in the SCP
		System.out.println("" == "" ? "True" : "False");	//String literals => SCP
		System.out.println(new String("") == new String("") ? "True" : "False"); //heap		
		System.out.println(""+"" == "" ? "True" : "False");	//String literals => SCP
	}
	
	public SynchronizedCornerCases(){
		synchronized(this){}	//You can have synchronized blocks in a constructor
	}
	
//	public synchronized SynchronizedCornerCases(int nope){}
	// You can't have a synchronized constructor

}
