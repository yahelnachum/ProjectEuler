package problems.main;

import problems.utility.Clock;

public class Main {

	public static void main(String[] args) {

		/*
		 * start clock, start problem, when the problem is done stop clock and
		 * print out results
		 */
		int problemNum = 32;
		Clock timer = new Clock();
		ProblemTerminal.solveOneToFiveHundred(problemNum);
		long delta = timer.delta();
		long milliseconds = delta % 1000;
		long seconds = (delta / 1000) % 60;
		long minutes = delta / 1000 / 60;

		System.out
				.printf("Time taken to solve problem %d was: %d minutes, %d seconds, and %d milliseconds.\n",
						problemNum, minutes, seconds, milliseconds);
	}

}
