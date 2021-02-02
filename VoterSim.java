import java.util.Random;

public abstract class Voter {

	// Patrick Ekeu
	// Project 1 Voter
	// February 1, 2021

	public static final int DEMOCRAT = 0; // private variables
	public static final int REPUBLICAN = 1;
	public static final int PRECINCTSIZE = 5;
	public static final int WIDTH = PRECINCTSIZE*20;
	public static final int HEIGHT = PRECINCTSIZE*5;
	public static final double SPREAD = 100.01;
	public static int nD;
	public static int nR;

	public static Voter [] [] state = new Voter [HEIGHT][WIDTH];
	public static Random rnd = new Random();


	public static int count(int rStart, int rEnd, int cStart, int cEnd, int type) // method that counts the amount of Democrats and Republicans 
	{
		nD = 0;
		nR = 0;
		if(type == 0)
		{
			for(int r = rStart; r < rEnd; r++)
			{
				for(int c = cStart; c<cEnd; c++)
				{
					if(state[r][c].getAffiliation() == DEMOCRAT)
						nD++;
				}
			}
			return nD;
		}
		else
		{
			for(int r = rStart; r < rEnd; r++)
			{
				for(int c = cStart; c<cEnd; c++)
				{
					if(state[r][c].getAffiliation() == REPUBLICAN)
						nR++;
				}
			}
			return nR;
		}
	}

	public static int count(int rStart, int rEnd, int cStart, int cEnd) // method that counts the total amount of voters in a specified area
	{
		int total = 0;
		nD = 0;
		nR = 0;
		for(int r = rStart; r < rEnd; r++)
		{
			for(int c = cStart; c<cEnd; c++)
			{
				if(state[r][c].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
			}
		}
		total = nD + nR;
		return total;

	}

	public static int districtAffiliation(int startr, int startc)
	{
		nD = 0;
		nR = 0;
		startr = 0;
		startc = 0;

		for(int r = startr; r < startr + 5; r++)
		{
			for(int c = startc; c < startc + 5; c++)
			{
				state[r][c].getAffiliation();
				if(state[r][c].getAffiliation() == DEMOCRAT)
				{
					nD++;
				}
				else
					nR++;
			}
		}

		if (nR > nD)
		{
			return Voter.REPUBLICAN;
		}
		else
			return Voter.DEMOCRAT;
	}


	public static Voter[][] initState() // initializes the state with null values
	{
		for(int outrow = 0; outrow < 20; outrow++)
		{			
			for(int row = 0; row < 5; row++) // row = 0, bump row by 1 until end, up to 4
			{
				for(int col = 0; col < 5; col++)
				{
					state[row][col] = null;
				}
			}
			for(int outcol = 0; outcol < 5; outcol++) // col = 0, bump col by 1, up to 4
			{
				state[outrow][outcol] = null;
			}
		}
		return state;
	}

	public static void printState() // Prints out the state in the console
	{
		for(int k = 0; k < 20; k++)
		{
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					System.out.print(state[i][j].toString() + " ");
				}
				System.out.println();
			}
			System.out.println();
			for(int l = 0; l < 5; l++)
			{
				System.out.print(state[k][l].toString() + " ");
			}
		}
		System.out.println();
	}


	public abstract int getAffiliation(); // abstract method
	{

	}


	public static void main(String[] args) 
	{
		initState(); 
		int randRow;
		int randCol;

		do // checks for 8 surrounding locations from the random spot in the state
		{
			randRow = rnd.nextInt(HEIGHT);
			randCol = rnd.nextInt(WIDTH);
			state[randRow][randCol] = new Democrat();
			if(state[randRow][randCol] == null)
			{
				if((randRow == 0) || (randCol == 0))
					continue;
				else
				{
					if(state[randRow - 1][randCol - 1].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if(randRow == 0)
					continue;
				else
				{
					if(state[randRow - 1][randCol].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if((randRow == 0) || (randCol == 100))
					continue;
				else
				{
					if(state[randRow - 1][randCol + 1].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if(randCol == 0)
					continue;
				else
				{
					if(state[randRow][randCol - 1].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if((randRow == 25) || (randCol == 0))
					continue;
				else
				{

					if(state[randRow + 1][randCol - 1].getAffiliation() == DEMOCRAT)
					{

						nD++;
					}
					else
						nR++;
				}
				if(randRow == 25)
					continue;
				else
				{
					if(state[randRow + 1][randCol].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if((randRow == 100) || (randCol == 100))
					continue;
				else
				{
					if(state[randRow + 1][randCol + 1].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}
				if(randCol == 100)
					continue;
				else
				{
					if(state[randRow][randCol + 1].getAffiliation() == DEMOCRAT)
					{
						nD++;
					}
					else
						nR++;
				}

				double form;
				form = (SPREAD + nD)/(2.0 * SPREAD)+ nR + nD;
				double randVal = rnd.nextDouble();

				if(form >= randVal)
				{
					state[randRow][randCol] = new Democrat(); 

				}
				else
				{
					state[randRow][randCol] = new Republican(); 
				}

			} 

		}	while ((state[randRow + 1][randCol + 1] == null) || (state[randRow][randCol + 1] == null) || (state[randRow][randCol - 1] == null) || (state[randRow - 1][randCol + 1] == null) ||
				(state[randRow - 1][randCol - 1] == null) || (state[randRow][randCol + 1] == null) || (state[randRow + 1][randCol - 1] == null));


		int numVoters = 0;
		while(numVoters < 2500)
		{
			numVoters++;
		}

		printState();

		System.out.println("Total Number of Voters: " + count(0,100,0,25));
		System.out.println("Total Number of Democrats: " + count(0,100,0,25,0));
		System.out.println("Total Number of Republicans: " + count(0,100,0,25,1));
		System.out.println("There are " + ((count(0,100,0,25,0)/count(0,100,0,25)) * 100) + "% of Democrats");
		System.out.println("There are " + ((count(0,100,0,25,1)/count(0,100,0,25)) * 100) + "% of Republicans");
		System.out.println("There are " +  (( WIDTH * HEIGHT) / Math.pow(PRECINCTSIZE, 2)) + " districts");
		System.out.println("% of districts voted Democratic");
		System.out.println("% of districts voted Republican");
	}
}

