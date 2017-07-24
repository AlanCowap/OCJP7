/**
 * Demo Anonymous Inner Classes (3 types)
 * - extending a class
 * - implementing an interface
 * - argument defined AIC
 * 
 * Sample usage of a Anonymous Inner Classes like those in the code below:
 * - define an OnClickListener and implement it's onClick method for a widget e.g. Button
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


/*
Output from this program is:
Anonymous Inner Classes 
Move like an .. Anonymous Inner (child) Class com.alancowap.ocjp7.inner_classes.AIC$1@15db9742
Eat like an .. Anonymous Inner (child) class com.alancowap.ocjp7.inner_classes.AIC$2@6d06d69c
Freeze like an .. Anonymous Inner (child) class com.alancowap.ocjp7.inner_classes.AIC$3@7852e922
 */