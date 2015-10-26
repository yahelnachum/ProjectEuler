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
	
	public static void sortArray(int firstIndex, int lastIndex, ArrayList<Integer> list){
		if(firstIndex >= lastIndex){
			return;
		}
		
		int pivot = list.get(lastIndex);
		
		int j = firstIndex;
		for(int i = firstIndex; i < lastIndex; i++){
			if(list.get(i) <= pivot){
				int temp = list.get(j);
				list.set(j, list.get(i));
				list.set(i, temp);
				j++;
			}
		}
		
		list.set(lastIndex, list.get(j));
		list.set(j, pivot);
		
		sortArray(firstIndex, j - 1, list);
		sortArray(j + 1, lastIndex, list);
	}
	
	public static boolean inReverseOrder(int firstIndex, int lastIndex, ArrayList<Integer> list){
		int value = list.get(firstIndex);
		for(int i = firstIndex; i <= lastIndex; i++){
			if(value >= list.get(i)){
				value = list.get(i);
			}
			else
				return false;
		}
		return true;
	}
	
	public static void swap(int index1, int index2, ArrayList<Integer> list){
		int num1 = list.get(index1);
		int num2 = list.get(index2);
		list.set(index1, num2);
		list.set(index2, num1);
		
	}
	
	public static ArrayList<Integer> getPrimes(int upperNumberBound){
		boolean isPrime[] = new boolean[upperNumberBound+1];
		
		// initialize all to true
		for(int i = 0; i < isPrime.length; i++){
			isPrime[i] = true;
		}
		
		// get rid of 0 and 1
		isPrime[0] = false;
		isPrime[1] = false;
		
		// get rid of all evens
		for(int i = 4; i < upperNumberBound+1; i+=2){
			isPrime[i] = false;
		}
		
		// go through each divisor and set multiples to false
		for(int divisor = 3; divisor < upperNumberBound+1; divisor += 2){
			for(int j = divisor + divisor; j < upperNumberBound+1; j += divisor){
				isPrime[j] = false;
			}
		}
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		for(int i = 3; i < upperNumberBound+1; i += 2){
			if(isPrime[i]){
				primeList.add(i);
			}
		}
		
		return primeList;
	}
}
