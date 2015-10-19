package problems.utility;

import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
	
	public static ArrayList<Integer> getDivisors(int number){
			
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		divisors.add(1);
		int originalNum = number;
		for(int i = 2; i < number; i++){
			if (originalNum % i == 0){
				number = originalNum / i;
				divisors.add(i);
				if(i != number)
					divisors.add(number);
			}
		}
		
		return divisors;
	}
	
	public static boolean isAbundant(int number){
		ArrayList<Integer> divisors = getDivisors(number);
		
		int sum = 0;
		for(int i = 0; i < divisors.size(); i++){
			sum += divisors.get(i);
		}
		
		if(sum > number)
			return true;
		else
			return false;
	}
	
	public static boolean numberIsSumOfTwoAbundantNumbers(int number, ArrayList<Integer> listOfAbundantNumbers){
		Collections.sort(listOfAbundantNumbers);
		for(int i = 0; i < listOfAbundantNumbers.size(); i++){
			for(int j = 0; j < listOfAbundantNumbers.size(); j++){
				int abundantSum = listOfAbundantNumbers.get(i) + listOfAbundantNumbers.get(j);
				if(abundantSum == number)
					return true;
				else if(abundantSum > number && i < j){
					j = listOfAbundantNumbers.size();
				}
				else if(abundantSum > number && i > j){
					return false;
				}
			}	
		}
		
		return false;
	}
}
