/*
 * Written By: A. L'Esperance
 * 
 * In the 20x20 grid given in text_files/project11grid.txt, what is
 * the greatest product of four adjacent numbers in the same direction 
 * (up, down, left, right, or diagonally)
 * 
 * Running Time: 3ms
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LargestProductInGrid {
	
	//constants for the grid height and width
	static final int GRID_WIDTH = 20;
	static final int GRID_HEIGHT = 20;

	public static void main(String[] args) throws IOException 
	{
		//Used to get the running time of the program
		long start = System.currentTimeMillis();
		
		//read in the grid into a 2D int array
		int[][] grid = readFile("text_files/project11grid.txt");
		
		//Define variables to keep track of the current product 
		//and compare it off of the greatest product
		int currentProduct = 0;
		int greatestProduct = 0;
		
		//Loop through all valid grid positions
		for(int i = 0; i < grid.length-1; i++)	
			for(int j = 0; j < grid[i].length-1; j++)
			{
				//Get the horizontal product
				if(j <= GRID_WIDTH - 4)
				{
					currentProduct = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//Get the vertical product
				if(i <= GRID_HEIGHT - 4)
				{
					currentProduct = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//Get the diagonal right product
				if(i <= GRID_HEIGHT - 4 && j <= GRID_WIDTH - 4)
				{
					currentProduct = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//Get the diagonal left product
				if(i <= GRID_HEIGHT - 4 && j >= 3)
				{
					currentProduct = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				
			}
		long end = System.currentTimeMillis();
		System.out.println(greatestProduct);
		System.out.println(end - start + " ms");

	}
	
	/*
	 * Reads in the 20x20 grid text file and assigns it into a 2D
	 * int array which is then returned.
	 * 
	 * @param filename - the name of the file
	 * 
	 * @return 2D int array containing the grid
	 */
	static int[][] readFile(final String filename) throws IOException
	{
		//Define a FileReader on the file and create
		//a BufferedReader to read the file
		FileReader input = new FileReader(filename);
		BufferedReader bufferReader = new BufferedReader(input);
		
		//Define the grid array
		int[][] array = new int[GRID_WIDTH][GRID_HEIGHT];
		
		//Read each line of the file and loop while we still have lines
		String line;
		int count = 0;
		while((line = bufferReader.readLine()) != null)
		{
			//Split the line whenever there is a whitespace (i.e. after
			//each number)/
			String[] tokens = line.split(" ");
			for(int i = 0; i < 20; i++)
			{
				//Add it into the array
				array[count][i] = Integer.parseInt(tokens[i]);
			}
			count++;
		}
		//Close the buffered reader and return the array
		bufferReader.close();
		return array;
	}

}
