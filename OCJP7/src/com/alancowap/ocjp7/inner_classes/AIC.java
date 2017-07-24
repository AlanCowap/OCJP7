/**
 * Demo Anonymous Inner Classes
 * - extending a class
 * - implementing an interface
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.inner_classes;

public class AIC {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Classes ");
		Animal an = new Animal(){
			void move(){
				System.out.println("Move like an .. Anonymous Inner (child) Class " + this);
			}
		};
		an.move();

		Edible edible = new Edible(){
			@Override
			public void eat() {
				System.out.println("Eat like an .. Anonymous Inner (child) class " + this);
			}			
		};
		edible.eat();
	}

}

abstract class Animal{
	abstract void move();	
}

interface Edible{
	void eat();
}