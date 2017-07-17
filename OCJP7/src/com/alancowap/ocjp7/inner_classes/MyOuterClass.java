/**
 * Demo a simple inner class.
 *  - Referencing an inner class from an outer class, and vice versa.
 *  - Referencing an inner class from another top-level class 
 * 
 * Sample usages of a simple inner class like that in the code below:
 * - a class to be sorted multiple ways - use inner classes to define implementations for Comparator interface
 * - defining a Database contract in Android, e.g. inner class for each Table in the Database
 * - define a ViewHolder in Android as an inner class, e.g. for a class extending RecyclerView.Adapter<MyOuterClass.MyInnerClass>{}
 * 
 * 
 * @author Alan Cowap
 *  
 */
package com.alancowap.ocjp7.inner_classes;

public class MyOuterClass {
	private int outerNum = 5;
	private int shadowNum = 12;
	
	public static void main(String[] args) {
		MyOuterClass outer = new MyOuterClass();
		outer.outerMethod();
		
		//Note the correct syntax for creating an inner class object.
		//We need a live outer object in order to create an inner object.
		MyInnerClass inner = outer.new MyInnerClass(); 
		inner.innerMethod();
		int num = inner.innerNum; //inner & outer class objects can access each others private variables 
		
		//This syntax is also acceptable.
//		inner = new MyOuterClass().new MyInnerClass(); 
		
		
	}
	
	public void outerMethod(){
		System.out.println("Outer Space " + shadowNum);	//12
	}	
	
	// Inner class
	class MyInnerClass{
		private int innerNum = 10;
		private int shadowNum = 20;
		
		public void innerMethod(){
			System.out.println("Inner Space "  + shadowNum); //20
			System.out.println("Inner Space this "  + this.shadowNum); //20
			System.out.println("Outer Space from Inner Space " + MyOuterClass.this.shadowNum ); //12
		}
	}

}


// This is a top-level class, it is NOT an inner class
class AnotherTopLevelClass{
	public void somemethod(){
		//Get a reference to an inner class from a separate class, note the syntax		
		MyOuterClass.MyInnerClass inner = new MyOuterClass().new MyInnerClass();
		inner.innerMethod();
	}
	
}
