
public class Multiples3And5 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int runningTotal = 0;
		for(int i = 1; i < 1000; i++)
		{
			if(isMultiple(i))
				runningTotal += i;
		}
		
		System.out.println(runningTotal);
		
	}
	
	public static boolean isMultiple(int num)
	{
		if(num % 3 == 0 || num % 5 == 0)
			return true;
		return false;
	}
	
}
