package problems.data_structures;

public class StringScorer{
	public static int getAlphabeticScore(String str){
		int sum = 0;
		for(int i = 0; i < str.length(); i++){
			sum += getAlphabeticScore(str.charAt(i));
		}
		return sum;
	}
	
	public static int getAlphabeticScore(char c){
		return c - '@';
	}
}
