/**
 * Demo Anonymous Inner Classes
 * - extending a class
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.inner_classes;

public class AIC {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Classes");
		Animal an = new Animal(){
			void move(){
				System.out.println("Move like a .. Anonymous Inner (child) Class " + this);
			}
		};
		an.move();
	}

}

abstract class Animal{
	abstract void move();	
}

