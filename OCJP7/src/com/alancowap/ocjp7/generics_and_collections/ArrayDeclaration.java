
/**
 * 
 * Demo declaration of arrays
 * @author Alan Cowap
 *
 */
package com.alancowap.ocjp7.generics_and_collections;

public class ArrayDeclaration{

	public static void main(String[] args){
		//Valid Object Reference Variable declarations
		int[] oneD;
		int[] twoD[];
		int[][] twoDarray = {{1,2,3,4}, {1,2,3,4}, {1,2}, {1,2,3}};
		int[] [] twoDarr, threeD[];
		int[][] []threeDarr;
//		int[][] []threeDarray, []fourD; //illegal
//		int[10] oneDarr; //illegal: can't specify a size in the ORV datatype
		
//		oneD = new int[]; //illegal an array declaration must have a size - have to create it
//		oneD = new int[-10]; // java.lang.NegativeArraySizeException at runtime, compiler ignores it
		oneD = new int[1_0];	//ok!
//		oneD = {1,2,3,4,5,6,7,8,9,0}; // constant values must be used at initialization
		
		int[] oneDarray = {1,2,3};	//ok
		oneDarray = null;
		oneDarray = new int[new Integer(10)];	//Auto-unboxing
		oneDarray = new int[10];	//Equivalent to above
		
		ArrayDeclaration arr = new ArrayDeclaration();
		arr.takeArray(oneDarray);
//		arr.takeArray(twoDarray); //illegal this is 2D but should be 1D
		arr.takeArray(twoDarray[2]); 
		
	}
	
	
	private void takeArray(int[] nums){
		for (int num : nums)
			System.out.print(num + ",");
	}
}
