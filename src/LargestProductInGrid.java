import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LargestProductInGrid {
	
	static final int GRID_WIDTH = 20;
	static final int GRID_HEIGHT = 20;

	public static void main(String[] args) throws IOException 
	{
		//read in the grid into a 2D int array
		int[][] grid = readFile("project11grid.txt");
		int currentProduct = 0;
		int greatestProduct = 0;
		
		for(int i = 0; i < grid.length-1; i++)	
			for(int j = 0; j < grid[i].length-1; j++)
			{
				//horizontal
				if(j <= GRID_WIDTH - 4)
				{
					currentProduct = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//vertical
				if(i <= GRID_HEIGHT - 4)
				{
					currentProduct = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//diagonal right
				if(i <= GRID_HEIGHT - 4 && j <= GRID_WIDTH - 4)
				{
					currentProduct = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				//diagonal left
				if(i <= GRID_HEIGHT - 4 && j >= 3)
				{
					currentProduct = grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];

					if(currentProduct > greatestProduct)
						greatestProduct = currentProduct;
				}
				
			}
		System.out.println(greatestProduct);

	}
	
	static int[][] readFile(final String filename) throws IOException
	{
		FileReader input = new FileReader(filename);
		BufferedReader bufferReader = new BufferedReader(input);
		
		int[][] array = new int[GRID_WIDTH][GRID_HEIGHT];
		
		String line;
		int count = 0;
		while((line = bufferReader.readLine()) != null)
		{
			String[] tokens = line.split(" ");
			for(int i = 0; i < 20; i++)
			{
				array[count][i] = Integer.parseInt(tokens[i]);
			}
			count++;
		}
		bufferReader.close();
		return array;
	}

}
