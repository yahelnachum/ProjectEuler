package problems.main;

import problems.one_to_one_hundred.ProblemsOneToTwentyFive;
import problems.one_to_one_hundred.ProblemsTwentySixToFifty;

public class ProblemTerminal {

	public static void solveOneToFiveHundred(int problemNumber){
		if(problemNumber > 500 || problemNumber < 1){
			System.out.printf("ERROR: problemNumber given is not supported by this function!\n");
			return ;
		}
		
		switch(problemNumber){
		case 1:
			ProblemsOneToTwentyFive.solveProblemOne();
			break;
		case 2:
			ProblemsOneToTwentyFive.solveProblemTwo();
			break;
		case 3:
			ProblemsOneToTwentyFive.solveProblemThree();
			break;
		case 4:
			ProblemsOneToTwentyFive.solveProblemFour();
			break;
		case 5:
			ProblemsOneToTwentyFive.solveProblemFive();
			break;
		case 6:
			ProblemsOneToTwentyFive.solveProblemSix();
			break;
		case 7:
			ProblemsOneToTwentyFive.solveProblemSeven();
			break;
		case 8:
			ProblemsOneToTwentyFive.solveProblemEight();
			break;
		case 9:
			ProblemsOneToTwentyFive.solveProblemNine();
			break;
		case 10:
			ProblemsOneToTwentyFive.solveProblemTen();
			break;
		case 11:
			ProblemsOneToTwentyFive.solveProblemEleven();
			break;
		case 12:
			ProblemsOneToTwentyFive.solveProblemTwelve();
			break;
		case 13:
			ProblemsOneToTwentyFive.solveProblemThirteen();
			break;
		case 14:
			ProblemsOneToTwentyFive.solveProblemFourteen();
			break;
		case 15:
			ProblemsOneToTwentyFive.solveProblemFifteen();
			break;
		case 16:
			ProblemsOneToTwentyFive.solveProblemSixteen();
			break;
		case 17:
			ProblemsOneToTwentyFive.solveProblemSeventeen();
			break;
		case 18:
			ProblemsOneToTwentyFive.solveProblemEighteen();
			break;
		case 19:
			ProblemsOneToTwentyFive.solveProblemNineteen();
			break;
		case 20:
			ProblemsOneToTwentyFive.solveProblemTwenty();
			break;
		case 21:
			ProblemsOneToTwentyFive.solveProblemTwentyOne();
			break;
		case 22:
			ProblemsOneToTwentyFive.solveProblemTwentyTwo();
			break;
		case 23:
			ProblemsOneToTwentyFive.solveProblemTwentyThree();
			break;
		case 24:
			ProblemsOneToTwentyFive.solveProblemTwentyFour();
			break;
		case 25:
			ProblemsOneToTwentyFive.solveProblemTwentyFive();
			break;
		case 26:
			ProblemsTwentySixToFifty.solveProblemTwentySix();
			break;
		case 27:
			ProblemsTwentySixToFifty.solveProblemTwentySeven();
			break;
		case 28:
			ProblemsTwentySixToFifty.solveProblemTwentyEight();
			break;
		case 29:
			ProblemsTwentySixToFifty.solveProblemTwentyNine();
			break;
		case 30:
			ProblemsTwentySixToFifty.solveProblemThirty();
			break;
		case 67:
			ProblemsTwentySixToFifty.solveProblemSixtySeven();
			break;
		}
		
	}
}
