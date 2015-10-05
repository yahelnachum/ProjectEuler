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
		case 9:
			solveProblemNine();
			break;
		case 10:
			solveProblemTen();
			break;
		case 11:
			solveProblemEleven();
			break;
		case 12:
			solveProblemTwelve();
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

	public static void solveProblemNine(){
		for(int a = 1; a < 1000; a++){
			for(int b = 1; b < 1000; b++){
				for(int c = 1; c < 1000; c++){
					if(a + b + c  == 1000 && a*a + b*b == c*c){
						System.out.printf("Product abc, where a+b+c = 1000 and {a,b,c} are a pythagorean triplet: %d\n", a*b*c);
						a = 1000;
						b = a;
						c = b;
					}
				}	
			}	
		}
	}

	public static void solveProblemTen(){
		int size = 2000000;
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
		
		long sum = 0;
		for(int i = 0; i < size; i++){
			if(primeList[i] == true && i < 2000000){
				sum += i;
			}
		}
		
		System.out.printf("Find the sum of all the primes below two million: %d\n", sum);
	}

	public static void solveProblemEleven(){
		int array[][] =  {{ 8, 2,22,97,38,15, 0,40, 0,75, 4, 5, 7,78,52,12,50,77,91, 8},
						  {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48, 4,56,62, 0},
						  {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30, 3,49,13,36,65},
						  {52,70,95,23, 4,60,11,42,69,24,68,56, 1,32,56,71,37, 2,36,91},
						  {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
						  {24,47,32,60,99, 3,45, 2,44,75,33,53,78,36,84,20,35,17,12,50},
						  {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
						  {67,26,20,68, 2,62,12,20,95,63,94,39,63, 8,40,91,66,49,94,21},
						  {24,55,58, 5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
						  {21,36,23, 9,75, 0,76,44,20,45,35,14, 0,61,33,97,34,31,33,95},
						  {78,17,53,28,22,75,31,67,15,94, 3,80, 4,62,16,14, 9,53,56,92},
						  {16,39, 5,42,96,35,31,47,55,58,88,24, 0,17,54,24,36,29,85,57},
						  {86,56, 0,48,35,71,89, 7, 5,44,44,37,44,60,21,58,51,54,17,58},
						  {19,80,81,68, 5,94,47,69,28,73,92,13,86,52,17,77, 4,89,55,40},
						  { 4,52, 8,83,97,35,99,16, 7,97,57,32,16,26,26,79,33,27,98,66},
						  {88,36,68,87,57,62,20,72, 3,46,33,67,46,55,12,32,63,93,53,69},
						  { 4,42,16,73,38,25,39,11,24,94,72,18, 8,46,29,32,40,62,76,36},
						  {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74, 4,36,16},
						  {20,73,35,29,78,31,90, 1,74,31,49,71,48,86,81,16,23,57, 5,54},
						  { 1,70,54,71,83,51,54,69,16,92,33,48,61,43,52, 1,89,19,67,48}};
		
		long largestProduct = 0;
		
		for(int i = 0; i < array.length-4; i++){
			for(int j = 0; j < array[0].length; j++){
				long product = array[i][j] * array[i+1][j] * array[i+2][j] * array[i+3][j];
				if(largestProduct < product)
					largestProduct = product;
			}
		}
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length-4; j++){
				long product = array[i][j] * array[i][j+1] * array[i][j+2] * array[i][j+3];
				if(largestProduct < product)
					largestProduct = product;
			}
		}
		
		for(int i = 0; i < array.length-4; i++){
			for(int j = 0; j < array[0].length-4; j++){
				long product = array[i][j] * array[i+1][j+1] * array[i+2][j+2] * array[i+3][j+3];
				if(largestProduct < product)
					largestProduct = product;
			}
		}
		
		for(int i = 3; i < array.length; i++){
			for(int j = 0; j < array[0].length-4; j++){
				long product = array[i][j] * array[i-1][j+1] * array[i-2][j+2] * array[i-3][j+3];
				if(largestProduct < product)
					largestProduct = product;
			}
		}
		
		System.out.printf("Greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid is: %d\n", largestProduct);
	}

	public static void solveProblemTwelve(){
		
	}
}

