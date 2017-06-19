/**
 * Demo exceptions in Java 7
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
		} catch (IOException e) {
			System.out.println("I caught something.");
		}finally{
			System.out.println("Finally...");			
		}
		System.out.println("I'm done trying.");
	}
	
	private void tryWithRes () throws FileNotFoundException, IOException{
		//try-with-resources requires neither a catch nor a finally; but it can have either or both.
		try(Reader r = new FileReader("somefile.txt")){
			//read a file
		}//no need to close the FileReader - it's done automagically 
		
	}

}
