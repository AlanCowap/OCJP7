/**
 * Demo Static Nested Class
 * - note that SNCs are not Inner classes
 * - the outer class contains a static reference to an instance of the inner class
 * - thus each outer class contains a single (static) reference to the inner class
 * - you can have multiple instances of the inner class as demonstrated below.
 * 
 * Sample usage of Static Inner Classes like that in the code below:
 * - defining a Database contract in Android, e.g. inner class for each Table in the Database
 * - and each inner class contains constants for each Column in the Table 
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.inner_classes;

public class StaticOuter {

	public static void main(String[] args) {
		System.out.println("Static Nested Class");
		DBContract.Person myPerson = new DBContract.Person();
		//myPerson refers to a new instance of the inner class
		//DBContract.Person statically refers to that same instance
		System.out.println("Table Name : " + myPerson.TABLE_NAME + ++myPerson.size);
		System.out.println("Table Name : " + DBContract.Person.TABLE_NAME);

		DBContract.Person myPerson2 = new DBContract.Person();
		//myPerson refers to a new second  instance of the inner class
		//DBContract.Person statically refers to that same instance
		// - but this is now a different object to that referred to by myPerson
		System.out.println("Table Name : " + myPerson2.TABLE_NAME + myPerson2.size);
		System.out.println("Table Name : " + myPerson.TABLE_NAME + myPerson.size);

		System.out.println(myPerson == myPerson2);
		
	}
}

class DBContract{
	static class Person{ // Note the reference to the nested class is STATIC
		int size = 10; //Yes, an SNC can have state - it's a normal object
		
		public static final String TABLE_NAME = "person";	//COLUMN
		//etc.
	}
}
