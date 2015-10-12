package problems.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import problems.data_structures.StringScorer;

public class FileInput {

	private static final String problemTwentyTwoFileName = "problemTwentyTwoNames.txt";
	public static ArrayList<String> getNamesArrayListForProblemTwentyTwo() {
		ArrayList<String> names = new ArrayList<String>();
		try {
			// open up file
			BufferedReader br = new BufferedReader(new FileReader(problemTwentyTwoFileName));
			try {
				String line = br.readLine();
				
				StringTokenizer strTokenizer = new StringTokenizer(line, "\",");
				
				while(strTokenizer.hasMoreTokens()){
					names.add(strTokenizer.nextToken());
				}
				
				// close file
				br.close();
				
			} finally {

			}
		} catch (Exception e) {

		}
		return names;
	}
}
