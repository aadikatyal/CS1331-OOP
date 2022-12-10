/**
 * 
 * I worked on the assignment alone, using only course-provided materials. 
 */

package aadikatyal.cs1331.hw1;

class StringOperations
{
	public static void main(String[] args)
	{
		String name = "Aadi";
		System.out.println(name);
		name = name.replace(String.valueOf(name.charAt(0)), "A").replace(String.valueOf(name.charAt(name.length() - 1)), "Z");
		System.out.println(name);
		
		String address = "www.gatech.edu";
		System.out.println(address);
		address = address.replace("www.", "").replace(".edu", "") + "1331";
		System.out.println(address);
		
	}
}