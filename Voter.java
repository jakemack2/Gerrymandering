/*
 * Jake Mack
 * CS 152 - Project 1- Gerrymandering
 * 1/27/2021
 */
public class Voter {

	// need two public constants democrat and republican
			public static final int DEMOCRAT = 0;
			public static final int REPUBLICAN = 1;
			
			// abstract method int getAffiliation
			
	public static void main(String[] args) {
		
		// 100X25 rectangle with 5X5 districts each having 25 voters
		// 1 2D array
		Voter [] [] grid = new Voter [100][25];
		
	
	
		
		// r=0,bump r by 5 until end, c to 4
		// c=0,bump c by 5 until end, r to 4
		
		// filling the states with voters
		// spread is small(.001) the board will clump
		// spread is large(100.0) the board will more spread
		// random voter, count # of D and R in the 8 surrounding spots
		// p = (SPREAD + nD)/(2(SPREAD) + nD + nR)
		
		// collecting statistics
		// total voters
		// total # and % of D and R
		// total # of districts
		// total # of % of districts that vote D and R

	}

}
