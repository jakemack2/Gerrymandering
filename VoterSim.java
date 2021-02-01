import java.util.Random;

public abstract class VoterSim {

	public static final int DEMOCRAT = 0;
	public static final int REPUBLICAN = 1;
	public static final int PRECINCTSIZE = 5;
	public static final int WIDTH = PRECINCTSIZE*20;
	public static final int HEIGHT = PRECINCTSIZE*5;
	public static final double SPREAD = 100.01;
	public static int nD;
	public static int nR;

	public static Voter [] [] state = new Voter [HEIGHT][WIDTH];
	public static Random rnd = new Random();

	public static int count(int rStart, int rEnd, int cStart, int cEnd, int type)
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
	
	public static int count(int rStart, int rEnd, int cStart, int cEnd)
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

	public static Voter[][] initState()
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

	public static void printState()
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


	public abstract int getAffiliation();
	{

	}

	

	public static void main(String[] args) 
	{

		initState();
		
		int democrat;
		int republican;
		int type;
		int randRow;
		int randCol;

		do 
		{
			randRow = rnd.nextInt(100) + 1;
			randCol = rnd.nextInt(25) + 1;
			if((randRow == 0) || (randCol == 0) || (randRow == HEIGHT + 1) || (randCol == WIDTH +1))
			{
				return;
			}
			if(state[randRow][randCol] == null)
			{
				if(state[randRow - 1][randCol - 1].getAffiliation() == nD)
					nD++;
				else
					nR++;
				if(state[randRow -1][randCol].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow -1][randCol+1].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow][randCol-1].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow +1][randCol - 1].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow +1][randCol].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow +1][randCol+1].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				if(state[randRow][randCol + 1].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
				
				int newRow;
				int newCol;
				newRow = randRow;
				newCol = randCol;
			
				if(nR > nD)
				{
					state[newRow][newCol] = REPUBLICAN; // Can you try to make this a republican?
				}
				
				if(nD > nR)
				{
					state[newRow][newCol] = DEMOCRAT; // Can you try to make this a democrat?
				}
			}	
			
		} while(!(state[randRow][randCol] == null));
		
		double form;
		form = (SPREAD + nD)/(2.0 * SPREAD)+ nR + nD;
		double randVal = rnd.nextDouble();
		if(randVal < form)
		{
			return REPUBLICAN;

		}
		else
		{
			return DEMOCRAT;
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

