package problems.one_to_one_hundred;


public class ProblemsOneToOneHundred {

	public static void solveOneToOneHundred(int problemNumber){
		if(problemNumber > 100 || problemNumber < 1){
			System.out.printf("ERROR: problemNumber given is not supported by this function!\n");
			return ;
		}
		
		switch(problemNumber){
		case 1:
			solveProblemOne();
			break;
		case 2:
			solveProblemTwo();
			break;
		case 3:
			solveProblemThree();
			break;
		case 4:
			solveProblemFour();
			break;
		case 5:
			solveProblemFive();
			break;
		case 6:
			solveProblemSix();
			break;
		case 7:
			solveProblemSeven();
			break;
		case 8:
			solveProblemEight();
			break;
		}
	}
	
	public static void solveProblemOne(){
		int sum = 0;
		int highestNumber = 1000;
		
		for(int i = 1; i < highestNumber; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		
		System.out.printf("Answer to problem 1 is: %d", sum);
	}
	
	public static void solveProblemTwo(){
		int previous = 1;
		int current  = 2;
		
		int sum = 0;
		
		while(current < (int) (4* Math.pow(10, 6))){
			if(current % 2 == 0)
				sum += current;
			
			current += previous;
			previous = current - previous;
		}
		
		System.out.printf("Answer to problem 2 is: %d", sum);
	}
	
	public static void solveProblemThree(){

		long num = 600851;
	    num *= 1000000;
	    num += 475143;
		
		int size = 1000000;
		boolean primeList[] = new boolean[size];
		for(int i = 0; i < size; i++){
			primeList[i] = true;
		}
		
		// get all evens to be false except for 2
		for(int i = 4; i < size; i+= 2){
			primeList[i] = false;
		}
		
		// go through all divisors and turn their multiples to false 
		for(long i = 3; i < size - 1; i+=2){
			long divisor = i;
			
			for(int j = (int) (divisor + divisor); j < size; j+=(int) divisor){
				primeList[j] = false;
			}
		}
		
		for(int i = size - 1; i > 0; i--){
			if(primeList[i] == true && num % i == 0){
				System.out.printf("Largest prime factor of 600851475143 is: %d", i);
				break;
			}
		}
	}

	public static void solveProblemFour(){
		int largestPalindrome = 0;
		for(int i = 999; i > 99; i--){
			for(int j = 999; j > 99; j--){
				
				int possiblePalindrome = i*j;
				int reversePalindrome = i*j;
				int length = 0;
				
				while(reversePalindrome > 0){
					reversePalindrome /= 10;
					length++;
				}
				
				for(int k = 0; k < length / 2; k++){
					reversePalindrome *= 10;
					reversePalindrome += possiblePalindrome % 10;
					possiblePalindrome /= 10;
				}
				
				if(length+1 % 2 == 0){
					possiblePalindrome /= 10;
				}
				
				if(reversePalindrome == possiblePalindrome && i*j > largestPalindrome){
					largestPalindrome = i*j;
				}
				
				
			}
		}
		
		System.out.printf("Largest palindrome made from the product of two 3-digit numbers: %d\n", largestPalindrome);
	}

	public static void solveProblemFive(){
		for(int i = 20; i < 1000000000; i+=20){
			boolean divisibleByAll = true;
			
			for(int j = 2; j < 21; j++){
				if(i % j != 0){
					divisibleByAll = false;
					j = 21;
				}
			}
			
			if(divisibleByAll){
				System.out.printf("Smallest positive number that is evenly divisible by all of the numbers from 1 to 20: %d\n", i);
				i = 1000000000;
			}
		}
	}

	public static void solveProblemSix(){
		int sumOfSquares = 0;
		int squareOfSums = 0;
		
		for(int i = 1; i < 101; i++){
			sumOfSquares += i*i;
			squareOfSums += i;
		}
		
		squareOfSums *= squareOfSums;
		
		System.out.printf("The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum: %d\n", squareOfSums - sumOfSquares);
	}

	public static void solveProblemSeven(){
		int size = 10000000;
		boolean primeList[] = new boolean[size];
		for(int i = 0; i < size; i++){
			primeList[i] = true;
		}
		primeList[0] = false;
		primeList[1] = false;
		
		// get all evens to be false except for 2
		for(int i = 4; i < size; i+= 2){
			primeList[i] = false;
		}
		
		// go through all divisors and turn their multiples to false 
		for(long i = 3; i < size - 1; i+=2){
			long divisor = i;
			
			for(int j = (int) (divisor + divisor); j < size; j+=(int) divisor){
				primeList[j] = false;
			}
		}
		
		int nthPrime = 0;
		for(int i = 0; i < size; i++){
			if(primeList[i] == true){
				nthPrime++;
				if(nthPrime == 10001){
					System.out.printf("10,001st prime number: %d\n", i);
					i = size;
				}
			}
		}
	}

	public static void solveProblemEight(){
		String number =     "73167176531330624919225119674426574742355349194934" + 
							"96983520312774506326239578318016984801869478851843" + 
							"85861560789112949495459501737958331952853208805511" + 
							"12540698747158523863050715693290963295227443043557" + 
							"66896648950445244523161731856403098711121722383113" + 
							"62229893423380308135336276614282806444486645238749" + 
							"30358907296290491560440772390713810515859307960866" + 
							"70172427121883998797908792274921901699720888093776" + 
							"65727333001053367881220235421809751254540594752243" + 
							"52584907711670556013604839586446706324415722155397" + 
							"53697817977846174064955149290862569321978468622482" + 
							"83972241375657056057490261407972968652414535100474" + 
							"82166370484403199890008895243450658541227588666881" + 
							"16427171479924442928230863465674813919123162824586" + 
							"17866458359124566529476545682848912883142607690042" + 
							"24219022671055626321111109370544217506941658960408" + 
							"07198403850962455444362981230987879927244284909188" + 
							"84580156166097919133875499200524063689912560717606" + 
							"05886116467109405077541002256983155200055935729725" + 
							"71636269561882670428252483600823257530420752963450";	
		
		long largestProduct = 0;
		for(int i = 0; i < number.length() - 12; i++){
			long product = 1;
			for(int j = i; j < i+13; j++){
				product *= Integer.parseInt(number.charAt(j) + "");
			}
			
			if(largestProduct < product)
				largestProduct = product;
		}
		
		System.out.printf("%d\n", largestProduct);
	}
}

