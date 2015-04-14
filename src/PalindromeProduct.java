/*
 * Written By: A. L'Esperance
 * 
 * Find the largest palindrome made from the product of
 * two 3-digit numbers.
 */
public class PalindromeProduct {

	public static void main(String[] args) 
	{
		//used to get running time
		long start = System.currentTimeMillis();
		int product;
		String result = "";
		int max = 0;
		
		//Problem is small enough let's use the good ol' brute force method
		for(int i = 999; i > 99; i--)
			for(int j = i - 1; j > 99; j--)
			{
				product = i * j;
				if(product > max && isPalindrome(Integer.toString(product)))
				{
					result = Integer.toString(product);
					max = product;
				}
					
			}
		System.out.println(result);
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}
	
	public static boolean isPalindrome(String num)
	{
		int length = num.length();
		String backwards = "";
		for(int i = length-1; i >= 0; i--)
			backwards += num.charAt(i);
		if(backwards.equals(num))
			return true;
		return false;
	}

}
