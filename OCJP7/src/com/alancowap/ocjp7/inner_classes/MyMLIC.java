/**
 * Class to demo MLIC - Method Local Inner Class 
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.inner_classes;

public class MyMLIC {

	public static void main(String[] args) {
		System.out.println("Demo MLIC - Method Local Inner Class");
		new MyMLIC().demoMLIC();
	}
	
	public void demoMLIC(){
		int badNum = 10;
		final int goodNum = 20;
		class MLIC{
			int innerPrim = 100;
			public void innerMethod(){
				System.out.println("I'm in the inner method of an MLIC");
//				System.out.println("Num is " + badNum); // can't access local non-final variables
				System.out.println("Num is " + goodNum); // can access local final variables
				
			}
		}		
		//Can only instantiate an MLIC inside a method and below MLIC declaration
		MLIC mlic = new MLIC();
		mlic.innerMethod();
	}

}
