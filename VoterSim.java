import java.util.Random;

public class VoterSim {

	public static final int PRECINCTSIZE = 5;
	public static final int WIDTH = PRECINCTSIZE*20;
	public static final int HEIGHT = PRECINCTSIZE*5;
	public static final double SPREAD = 100.01;
	
	public static Voter [] [] grid = new Voter [HEIGHT][WIDTH];
	public static Random rnd = new Random();
	
}
