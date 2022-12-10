/**
 * 
 * I worked on the assignment alone, using only course-provided materials. 
 */

package aadikatyal.cs1331.hw1;

class PrimitiveOperations
{
	public static void main(String[] args)
	{
		int num1 = 5;
		double num2 = 10.2;
		
		System.out.println(num1);
		System.out.println(num2);
		
		double product = num1 * num2;
		System.out.println(product);
		
		float floatNum = (float) num1;
		System.out.println(floatNum);
		
		int intNum = (int) num2;
		System.out.println(intNum);
		
		char c = 'A';
		System.out.println(c);
		
		// A = 65, a = 97, 97 - 65 = 32
		c += 32;
		System.out.println(c);
	}
}