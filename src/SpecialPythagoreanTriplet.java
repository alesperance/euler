/*
 * Written By: A. L'Esperance
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product of abc
 */
public class SpecialPythagoreanTriplet 
{
	static final int TOTAL = 1000;
	
	public static void main(String[] args) 
	{
		long start = System.currentTimeMillis();
		int product = 0;
		//loop through all possible values
		for(int i = 0; i < 1000; i++)
			for(int j = i+1; j < 1000; j++)
				for(int k = j+1; k < 1000; k++)
				{
					if(IsPythagoreanTriplet(i, j, k))
					{
						product = i * j * k;
						long end = System.currentTimeMillis();
						System.out.println(product);
						System.out.println(end - start + "ms");
						return;
					}
				}
	}
	
	public static boolean IsPythagoreanTriplet(int a, int b, int c)
	{
		//First check our initial condition for a pythagorean triplet
		if (a < b && b < c)
		{
			//calculate the sum
			int sum = a + b + c;
			
			//Ensure that the sum is equal to our total.  We check this first
			//To avoid needless computation with the Math.pow functions.
			if(sum == TOTAL)
			{
				//calculate both the left and right sides of the pythagorean theorem
				double leftSide = Math.pow(a, 2) + Math.pow(b, 2);
				double rightSide = Math.pow(c,  2);
				
				//Ensure that both sides are equal, if they are, return true
				if(leftSide == rightSide)
					return true;
			}
		}
		return false;
	}

}
