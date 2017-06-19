/**
 * Demo exceptions in Java 7
 * Check the JLS (Java Language Specification) for info on Exceptions:
 *  - https://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.20
 * try-with-resources
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exceptional {

	public static void main(String[] args){
		System.out.println("Demo Exceptions");		
		Exceptional ex = new Exceptional();
		
		try {
			System.out.println("Let's try this..");
			ex.tryWithRes();
			System.out.println("You won't see this if an Exception was thrown.");			
		} catch (IOException e) {
			System.out.println("You will see this if an Exception was thrown and caught..");
			//return; //you can call return, but finally will ALWAYS be run (unless you System.exit or pull the power!)
		}finally{
			System.out.println("You will always see this finally, Exception thrown or not");			
		}
		System.out.println("We caught and handled the Exception so our program continued to run.");
	}
	
	private void tryWithRes () throws FileNotFoundException, IOException{
		//try-with-resources requires neither a catch nor a finally; but it can have either or both.
		//Note if tryWithRes() doesn't handle the exceptions (which it doesn't) then it must declare them (which it does). #CatchOrDeclare
		try(Reader r = new FileReader("somefile.txt")){
			//read a file
		}//no need to close the FileReader - it's done automagically 
		
	}

}
