import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/*
 * Written By: Alex L'Esperance
 * 
 * Work out the first ten digits of the sum of the one-hundred
 * 50-digit numbers contained within text_files/largesum.txt
 * 
 * Running Time: 26ms
 */
public class LargeSum 
{
	/*
	 * BigInteger Array to keep track of BigInteger Numbers being read in
	 */
	static BigInteger[] bigIntArray = new BigInteger[100];

	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		
		//Read in the file, compute the sum, get the first ten digits
		readFile("text_files/largesum.txt");
		BigInteger sum = computeSum();
		String output = String.valueOf(sum);
		String firstTen = output.substring(0, 10);
		
		long end = System.currentTimeMillis();
		System.out.println(firstTen);
		System.out.println(end - start + "ms");
	}
	
	
	static BigInteger computeSum()
	{
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < bigIntArray.length; i++)
		{
			sum = sum.add(bigIntArray[i]);
		}
		return sum;
	}
	
	static void readFile(final String filename) throws IOException
	{
		FileReader input = new FileReader(filename);
		BufferedReader bufferReader = new BufferedReader(input);
		
		String line;
		int count = 0;
		while((line = bufferReader.readLine()) != null)
		{
			bigIntArray[count++] = new BigInteger(line);
		}
		
		bufferReader.close();
	}

}
