/**
 * Demo Anonymous Inner Classes
 * - extending a class
 * - implementing an interface
 * - argument defined AIC
 * 
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.inner_classes;

public class AIC {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Classes ");
		//AIC Type 1 - extending a class
		Animal an = new Animal(){
			void move(){
				System.out.println("Move like an .. Anonymous Inner (child) Class " + this);
			}
		};
		an.move();

		//AIC Type 2 - implementing an interface
		Edible edible = new Edible(){
			@Override
			public void eat() {
				System.out.println("Eat like an .. Anonymous Inner (child) class " + this);
			}			
		};
		edible.eat();

		//AIC Type 3 - argument defined 		
		new AIC().freeze(new Freezable(){
			@Override
			public void freeze() {
				System.out.println("Freeze like an .. Anonymous Inner (child) class " + this);				
			}			
		});
		
	}
	
	public void freeze(Freezable entity){
		entity.freeze();
	}	
	
}

abstract class Animal{
	abstract void move();	
}

interface Edible{
	void eat();
}

interface Freezable{
	void freeze();
}