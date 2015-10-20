package problems.main;

import problems.one_to_one_hundred.ProblemsOneToOneHundred;
import problems.utility.Clock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int problemNum = 26;
		Clock timer = new Clock();
		ProblemsOneToOneHundred.solveOneToOneHundred(problemNum);
		long delta = timer.delta();
		long milliseconds = delta % 1000;
		long seconds = (delta / 1000) % 60;
		long minutes = delta / 1000 / 60;
		
		System.out.printf("Time taken to solve problem %d was: %d minutes, %d seconds, and %d milliseconds.\n", problemNum, minutes, seconds, milliseconds);
	}

}
