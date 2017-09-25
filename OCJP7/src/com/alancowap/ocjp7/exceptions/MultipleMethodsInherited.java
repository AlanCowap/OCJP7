/**
 * Demonstrate implementing methods with similar signatures but different Exceptions thrown from multiple interfaces
 * 
 * @author Alan Cowap
 *
 */

package com.alancowap.ocjp7.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class MultipleMethodsInherited implements Readable, Writable{

	public static void main(String[] args) {
		System.out.println("Demo of multiple methods ");
		

	}

//	@Override
//	public void open() throws SQLException {}	// not compatible with Writable.open()

//	@Override
//	public void open() throws IOException {}	// not compatible with Readable.open()

//	@Override
//	public void open() throws SQLException, IOException {}	// not compatible with Writable.open() or Readable.open()

//	@Override
//	public void open() throws Exception {}	// Exceptions thrown by overriding methods must be invariant, covariant, or none
	// Note invariant and covariant are excluded in this specific example per above three code snippets.  

	@Override
	public void open(){}	// Woohoo! Exceptions thrown by overriding methods must be invariant, covariant, or none

	
}
