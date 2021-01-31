import java.util.Random;

public class VoterSim {

	public static final int PRECINCTSIZE = 5;
	public static final int WIDTH = PRECINCTSIZE*20;
	public static final int HEIGHT = PRECINCTSIZE*5;
	public static final double SPREAD = 100.01;
	
	public static Voter [] [] grid = new Voter [HEIGHT][WIDTH];
	public static Random rnd = new Random();
	
	int p;
	
	p = (SPREAD + nD)/(2(SPREAD)+ nR + nD);
	
	public static int count(int rStart, int rEnd, int cStart, int cEnd, int type)
	{
		int total = 0;
		for(int r = rStart; r < rEnd; r++)
		{
			for(int c = cStart; c<cEnd; c++)
			{
				if(state[r][c].getAffiliation() == DEMOCRAT)
					nD++;
				else
					nR++;
			}
			total = nD + nR;
			
		}
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
					System.out.print(state[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			for(int l = 0; l < 5; l++)
			{
				System.out.print(state[k][l] + " ");
			}
		}
		System.out.println();
	}
	
	public abstract int getAffiliation();
	{
			int randRow = rnd.nextInt(100);
			int randCol = rnd.nextInt(25);
			if(state[randRow][randCol] == null)
			{
				
			}
	
		
		
		
		double form;
		form = (SPREAD + nD)/(2.0 * SPREAD)+ nR + nD;
		double randVal = rnd.nextDouble();
		if(randVal < form)
		{
			
		}
		
	}
	
	
}
