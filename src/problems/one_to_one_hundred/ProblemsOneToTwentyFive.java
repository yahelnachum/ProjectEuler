package problems.one_to_one_hundred;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import problems.data_structures.StringScorer;
import problems.data_structures.TriangleNode;
import problems.utility.FileInput;
import problems.utility.Numbers;

/**
 * @author yahel
 *
 * Solves problems 1 - 25
 */
public class ProblemsOneToTwentyFive {
	
	/**
	 *  Multiples of 3 and 5
	 */
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
	
	/**
	 * Even fibonacci numbers
	 */
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
	
	/**
	 * Largest prime factor
	 */
	public static void solveProblemThree(){

		long num = 600851;
	    num *= 1000000;
	    num += 475143;
		
	    // generate prime number list
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

	/**
	 * Largest palindrome product
	 */
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

	/**
	 * Smallest multiple
	 */
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

	/**
	 * Sum square difference
	 */
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

	/**
	 * 100001st prime
	 */
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

	/**
	 * Largest product in series
	 */
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

	/**
	 * Pythagorean triplet
	 */
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

	/**
	 * Summation of primes
	 */
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

	/**
	 * Largest product in a grid
	 */
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

	/**
	 * Highly divisible triangular number
	 */
	public static void solveProblemTwelve(){
		long number = 0;
		boolean foundAnswer = false;
		//System.out.printf("\n100: %d\n", getNumberOfDivisors(100));
		for(int i = 1; i < 100000; i++){
			number += i;
			if(getNumberOfDivisors(number) > 500){
				foundAnswer = true;
				i = 100000;
			}
		}
		
		if(foundAnswer)
			System.out.printf("The value of the first triangle number to have over five hundred divisors: %d\n", number);
	}
	
	private static int getNumberOfDivisors(long number){
		long originalNum = number;
		int numOfDivisors = 1;
		for(long i = 2; i < number; i++){
			if (originalNum % i == 0){
				numOfDivisors += 2;
				number = originalNum / i;
			}
		}
		
		return numOfDivisors;
	}
	
	/**
	 * Large sum
	 */
	public static void solveProblemThirteen(){
		String strNumbers[] = {  "37107287533902102798797998220837590246510135740250",
								 "46376937677490009712648124896970078050417018260538",
								 "74324986199524741059474233309513058123726617309629",
								 "91942213363574161572522430563301811072406154908250",
								 "23067588207539346171171980310421047513778063246676",
								 "89261670696623633820136378418383684178734361726757",
								 "28112879812849979408065481931592621691275889832738",
								 "44274228917432520321923589422876796487670272189318",
								 "47451445736001306439091167216856844588711603153276",
								 "70386486105843025439939619828917593665686757934951",
								 "62176457141856560629502157223196586755079324193331",
								 "64906352462741904929101432445813822663347944758178",
								 "92575867718337217661963751590579239728245598838407",
								 "58203565325359399008402633568948830189458628227828",
								 "80181199384826282014278194139940567587151170094390",
								 "35398664372827112653829987240784473053190104293586",
								 "86515506006295864861532075273371959191420517255829",
								 "71693888707715466499115593487603532921714970056938",
								 "54370070576826684624621495650076471787294438377604",
								 "53282654108756828443191190634694037855217779295145",
								 "36123272525000296071075082563815656710885258350721",
								 "45876576172410976447339110607218265236877223636045",
								 "17423706905851860660448207621209813287860733969412",
								 "81142660418086830619328460811191061556940512689692",
								 "51934325451728388641918047049293215058642563049483",
								 "62467221648435076201727918039944693004732956340691",
								 "15732444386908125794514089057706229429197107928209",
								 "55037687525678773091862540744969844508330393682126",
								 "18336384825330154686196124348767681297534375946515",
								 "80386287592878490201521685554828717201219257766954",
								 "78182833757993103614740356856449095527097864797581",
								 "16726320100436897842553539920931837441497806860984",
								 "48403098129077791799088218795327364475675590848030",
								 "87086987551392711854517078544161852424320693150332",
								 "59959406895756536782107074926966537676326235447210",
								 "69793950679652694742597709739166693763042633987085",
								 "41052684708299085211399427365734116182760315001271",
								 "65378607361501080857009149939512557028198746004375",
								 "35829035317434717326932123578154982629742552737307",
								 "94953759765105305946966067683156574377167401875275",
								 "88902802571733229619176668713819931811048770190271",
								 "25267680276078003013678680992525463401061632866526",
								 "36270218540497705585629946580636237993140746255962",
								 "24074486908231174977792365466257246923322810917141",
								 "91430288197103288597806669760892938638285025333403",
								 "34413065578016127815921815005561868836468420090470",
								 "23053081172816430487623791969842487255036638784583",
								 "11487696932154902810424020138335124462181441773470",
								 "63783299490636259666498587618221225225512486764533",
								 "67720186971698544312419572409913959008952310058822",
								 "95548255300263520781532296796249481641953868218774",
								 "76085327132285723110424803456124867697064507995236",
								 "37774242535411291684276865538926205024910326572967",
								 "23701913275725675285653248258265463092207058596522",
								 "29798860272258331913126375147341994889534765745501",
								 "18495701454879288984856827726077713721403798879715",
								 "38298203783031473527721580348144513491373226651381",
								 "34829543829199918180278916522431027392251122869539",
								 "40957953066405232632538044100059654939159879593635",
								 "29746152185502371307642255121183693803580388584903",
								 "41698116222072977186158236678424689157993532961922",
								 "62467957194401269043877107275048102390895523597457",
								 "23189706772547915061505504953922979530901129967519",
								 "86188088225875314529584099251203829009407770775672",
								 "11306739708304724483816533873502340845647058077308",
								 "82959174767140363198008187129011875491310547126581",
								 "97623331044818386269515456334926366572897563400500",
								 "42846280183517070527831839425882145521227251250327",
								 "55121603546981200581762165212827652751691296897789",
								 "32238195734329339946437501907836945765883352399886",
								 "75506164965184775180738168837861091527357929701337",
								 "62177842752192623401942399639168044983993173312731",
								 "32924185707147349566916674687634660915035914677504",
								 "99518671430235219628894890102423325116913619626622",
								 "73267460800591547471830798392868535206946944540724",
								 "76841822524674417161514036427982273348055556214818",
								 "97142617910342598647204516893989422179826088076852",
								 "87783646182799346313767754307809363333018982642090",
								 "10848802521674670883215120185883543223812876952786",
								 "71329612474782464538636993009049310363619763878039",
								 "62184073572399794223406235393808339651327408011116",
								 "66627891981488087797941876876144230030984490851411",
								 "60661826293682836764744779239180335110989069790714",
								 "85786944089552990653640447425576083659976645795096",
								 "66024396409905389607120198219976047599490197230297",
								 "64913982680032973156037120041377903785566085089252",
								 "16730939319872750275468906903707539413042652315011",
								 "94809377245048795150954100921645863754710598436791",
								 "78639167021187492431995700641917969777599028300699",
								 "15368713711936614952811305876380278410754449733078",
								 "40789923115535562561142322423255033685442488917353",
								 "44889911501440648020369068063960672322193204149535",
								 "41503128880339536053299340368006977710650566631954",
								 "81234880673210146739058568557934581403627822703280",
								 "82616570773948327592232845941706525094512325230608",
								 "22918802058777319719839450180888072429661980811197",
								 "77158542502016545090413245809786882778948721859617",
								 "72107838435069186155435662884062257473692284509516",
								 "20849603980134001723930671666823555245252804609722",
								 "53503534226472524250874054075591789781264330331690"};
		
		long every10[] = new long[5];
		long first10[] = new long[5];
		BigInteger sum = BigInteger.ZERO;

		for(int i = 0; i < strNumbers.length; i++){
			long sub[] = new long[5];
			
			for(int j = 0; j < 5; j++){
				sub[j] = Long.parseLong(strNumbers[i].substring((j*10), (j+1)*10));
			}
			
			for(int j = 4; j >= 0; j--){
				every10[j] += sub[j];
				
				if(j != 0){
					double power = 9.0;
					long overFlow = (every10[j] - (every10[j] % (int)Math.pow(10.0, power))) / (int)Math.pow(10.0, power);
					every10[j] = (every10[j] % (int)Math.pow(10.0, power));
					every10[j-1] += overFlow;
				}
			}
			
			first10[0] += sub[0];
			printEvery10Number(every10);
			sum = sum.add(new BigInteger(strNumbers[i]));
		}
		
		System.out.printf("actual 1  :%d", every10[0]);
		System.out.printf("%40d\n", every10[4]);
		System.out.printf("expected  :5537376230\n");
		System.out.printf("actual 2  :%d\n", first10[0]);
		System.out.println("actual 3  :" +sum);
	}
	
	private static void printEvery10Number(long array[]){
		for(int i = 0; i < array.length; i++){
			
			long temp = array[i];
			int length = 0;
			while(temp > 0){
				temp /= 10;
				length++;
			}
			
			for(int j = length; j < 10; j++){
				System.out.printf("0");
			}
			
			System.out.printf("%d", array[i]);
		}
		
		System.out.println();
	}
	
	/**
	 * Longest Collatz sequence
	 */
	public static void solveProblemFourteen(){
		long largestNum = 0;
		int largestSequence = 0;
		for(long i = 999999; i > 0; i--){
			int sequence = getSequenceLength(i, 0);
			
			if(largestSequence < sequence){
				largestSequence = sequence;
				largestNum = i;
			}
		}
		
		System.out.printf("The starting number, under one million, produces the longest chain is: %d\n", largestNum);

	}
	
	private static int getSequenceLength(long num, int length){
		if(num <= 1){
			return length;
		}
		else if(num % 2 == 0){
			num = (num / 2);
			length++;
			return getSequenceLength(num, length);
		}
		else{
			num = (num * 3 + 1);
			length++;
			return getSequenceLength(num, length);
		}
	}
	
	/**
	 * Lattice paths
	 */
	public static void solveProblemFifteen(){
		long pascalTriangleRow[] = getPascalTriangleRow(41);
		System.out.printf("Routes there are through a 20×20 grid: %d\n", pascalTriangleRow[pascalTriangleRow.length / 2]);
	}
	
	private static long[] getPascalTriangleRow(int rowNumber){
		long[] oldRow = {1};
		long[] newRow = oldRow;
		for(int i = 2; i < rowNumber+1; i++){
			newRow = new long[i];
			for(int j = 0; j < newRow.length; j++){
				if(j == 0 || j == newRow.length - 1){
					newRow[j] = 1;
				}
				else{
					newRow[j] = oldRow[j-1] + oldRow[j];
				}
			}
			oldRow = newRow;
		}
		
		return newRow;
	}
	
	/**
	 * Power digit sum
	 */
	public static void solveProblemSixteen(){
		BigInteger power = new BigInteger("2");
		BigInteger base = new BigInteger("2");
		
		for(int i = 2; i <= 1000; i++){
			base = base.multiply(power);
		}
		
		String strNum = base.toString();
		int sumOfDigits = 0;
		for(int i = 0; i < strNum.length(); i++){
			sumOfDigits += Integer.parseInt(strNum.substring(i, i+1));
		}
		
		System.out.printf("The sum of the digits of the number 2^1000: %d\n", sumOfDigits);
	}
	
	
	/**
	 * Number letter counts
	 */
	public static void solveProblemSeventeen(){
		int sumOfLength = 0;
		for(int i = 1; i < 1000; i++){
			sumOfLength += numberToString(i).length();
		}
		sumOfLength += "onethousand".length();
		System.out.printf("Length of the string of all the numbers from 1 to 1000 (inclusive) written out in words: %d\n",sumOfLength);
	}
	
	public static String numberToString(int num){
		if(num >= 0 && num <= 15){
			switch(num){
			case 0:
				return "";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			case 10:
				return "ten";
			case 11:
				return "eleven";
			case 12:
				return "twelve";
			case 13:
				return "thirteen";
			case 14:
				return "fourteen";
			case 15:
				return "fifteen";
			default:
				return "";
			}
		}
		else if(num == 18){
			return numberToString(num % 10) + "een";
		}
		else if(num >= 16 && num <= 19){
			return numberToString(num % 10) + "teen";
		}
		else if(num >= 20 && num <= 29){
			return "twenty" + numberToString(num % 20);
		}
		else if(num >= 30 && num <= 39){
			return "thirty" + numberToString(num % 30);
		}
		else if(num >= 40 && num <= 49){
			return "forty" + numberToString(num % 40);
		}
		else if(num >= 50 && num <= 59){
			return "fifty" + numberToString(num % 50);
		}
		else if(num >= 80 && num <= 89){
			int number = num / 10;
			number *= 10;
			return numberToString(num / 10) + "y" + numberToString(num % number);
		}
		else if(num >= 60 && num <= 99){
			int number = num / 10;
			number *= 10;
			return numberToString(num / 10) + "ty" + numberToString(num % number);
		}
		else if(num >= 100){
			String restOfNum = "and" + numberToString(num % 100);
			if(restOfNum.compareTo("and") == 0){
				restOfNum = "";
			}
			return numberToString(num / 100) + "hundred" + restOfNum;
		}
		
		return "";
	}
	
	/**
	 * Maximum path sum I
	 */
	public static void solveProblemEighteen(){
		int[][] triangleInt = { {75},
								{95,64},
								{17,47,82},
								{18,35,87,10},
								{20,04,82,47,65},
								{19,01,23,75,03,34},
								{88,02,77,73,07,63,67},
								{99,65,04,28,06,16,70,92},
								{41,41,26,56,83,40,80,70,33},
								{41,48,72,33,47,32,37,16,94,29},
								{53,71,44,65,25,43,91,52,97,51,14},
								{70,11,33,28,77,73,17,78,39,68,17,57},
								{91,71,52,38,17,14,91,43,58,50,27,29,48},
								{63,66,04,68,89,53,67,30,73,16,69,87,40,31},
								{04,62,98,27,23, 9,70,98,73,93,38,53,60,04,23}};
		
		TriangleNode[][] triangleNodes = new TriangleNode[triangleInt.length][];
		for(int i = 0; i < triangleInt.length; i++){
			triangleNodes[i] = new TriangleNode[triangleInt[i].length];
			for(int j = 0; j < triangleInt[i].length; j++){
				triangleNodes[i][j] = new TriangleNode(triangleInt[i][j], i);
			}
		}
		
		for(int i = 0; i < triangleNodes.length - 1; i++){
			for(int j = 0; j < triangleNodes[i].length; j++){
				triangleNodes[i][j].addNeighbor(triangleNodes[i+1][j]);
				triangleNodes[i][j].addNeighbor(triangleNodes[i+1][j+1]);
			}
		}
		
		int largestSum = 0;
		for(int i = 0; i < triangleNodes[triangleNodes.length - 1].length; i++){
			if(triangleNodes[triangleNodes.length - 1][i].getSum() > largestSum)
				largestSum = triangleNodes[triangleNodes.length - 1][i].getSum();
		}
		
		System.out.printf("Maximum total from top to bottom of the triangle is: %d\n", largestSum);
	}
	
	/**
	 * Counting Sundays
	 */
	public static void solveProblemNineteen(){
		// January 		31
		// February		28/29
		// March 		31
		// April 		30
		// May 			31
		// June 		30
		// July 		31
		// August 		31
		// September 	30
		// October 		31
		// November 	30
		// December 	31
		int daysInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int sumOfDays = 1;
		int numOfSundays = 0;
		for(int year = 1900; year < 2001; year++){
			for(int month = 0; month < daysInMonth.length; month++){
				sumOfDays += daysInMonth[month];
				if(year % 4 == 0 && month == 1 && year != 1900){
					sumOfDays++;
				}
				if(sumOfDays % 7 == 0 && year != 1900){
					numOfSundays++;
				}
			}
		}
		
		System.out.printf("The number of Sundays that fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000) is: %d\n", numOfSundays);
		
	}
	
	/**
	 * Factorial digit sum
	 */
	public static void solveProblemTwenty(){
		BigInteger factorialNum = new BigInteger("1");
		for(int i = 2; i < 101; i++){
			factorialNum = factorialNum.multiply(new BigInteger("" + i));
		}
		String strFactorialNum = factorialNum.toString();
		
		int sumOfDigits = 0;
		for(int i = 0 ; i < strFactorialNum.length(); i++){
			sumOfDigits += Integer.parseInt(strFactorialNum.substring(i, i+1));
		}
		
		System.out.printf("The sum of the digits in the number 100! is: %d\n", sumOfDigits);
	}
	
	/**
	 * Amicable numbers
	 */
	public static void solveProblemTwentyOne(){
		int amicableSum = 0;
		for(int i = 2; i < 10000; i++){
			int a1 = i;
			int a2 = 0;
			int b = 0;
			ArrayList<Integer> aDivisors = Numbers.getDivisors(a1);
			for(int j = 0; j < aDivisors.size(); j++){
				b += aDivisors.get(j);
			}
			ArrayList<Integer> bDivisors = Numbers.getDivisors(b);
			for(int j = 0; j < bDivisors.size(); j++){
				a2 += bDivisors.get(j);
			}
			
			if(a1 != b && a1 == a2){
				amicableSum += a1;
			}
		}
		System.out.printf("The sum of all the amicable numbers under 10000 is: %d\n", amicableSum);
	}
	
	/**
	 * Names scores
	 */
	public static void solveProblemTwentyTwo(){
		ArrayList<String> namesList = new ArrayList<String>();
		namesList = FileInput.getNamesArrayListForProblemTwentyTwo();
		Collections.sort(namesList);
		
		int sum = 0;
		for(int i = 0; i < namesList.size(); i++){
			sum += ((i+1) * StringScorer.getAlphabeticScore(namesList.get(i)));
		}
		
		System.out.printf("The total of all the name scores in the file \"./problemTwentyTwoNames.txt\" is: %d\n", sum);
	}
	
	/**
	 * Non-abundant sums
	 */
	public static void solveProblemTwentyThree(){
		int maxNumber = 28123+1;
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		for(int i = 1; i < maxNumber; i++){
			if(Numbers.isAbundant(i)){
				abundantNumbers.add(i);
			}
		}
		
		int sumOfNonAbundantNumbersSum = 0;
		for(int i = 1; i < maxNumber; i++){
			if(!Numbers.numberIsSumOfTwoAbundantNumbers(i, abundantNumbers))
				sumOfNonAbundantNumbersSum += i;
		}
		
		System.out.printf("The sum of all the positive integers which cannot be written as the sum of two abundant numbers is: %d\n", sumOfNonAbundantNumbersSum);
	}
	
	/**
	 * Lexicographic permutations
	 */
	public static void solveProblemTwentyFour(){
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(0);
		listOfNumbers.add(1);
		listOfNumbers.add(2);
		listOfNumbers.add(3);
		listOfNumbers.add(4);
		listOfNumbers.add(5);
		listOfNumbers.add(6);
		listOfNumbers.add(7);
		listOfNumbers.add(8);
		listOfNumbers.add(9);

		int iteration = 1;
		int focus = listOfNumbers.size() - 1;
		while(focus != 0){

			if(getNextLexigraphicNumberIndex(focus, listOfNumbers) == focus){
				 Numbers.swap(focus, focus - 1, listOfNumbers);
				 Numbers.sortArray(focus, listOfNumbers.size() - 1, listOfNumbers);
				 focus = listOfNumbers.size() - 1;
				 iteration++;
			}
			else if(getNextLexigraphicNumberIndex(focus, listOfNumbers) == 1000){
				focus--;
			}
			else{
				int index = getNextLexigraphicNumberIndex(focus, listOfNumbers);
				Numbers.swap(focus - 1, index, listOfNumbers);
				Numbers.sortArray(focus, listOfNumbers.size() - 1, listOfNumbers);
				focus = listOfNumbers.size() - 1;
				iteration++;
			}

			if(iteration == 1000000){
				break;
			}
		}
		
		System.out.printf("The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9 is: ");
		for(int i = 0; i < listOfNumbers.size(); i++){
			System.out.printf("%d", listOfNumbers.get(i));
		}
		System.out.println();
	}
	
	private static int getNextLexigraphicNumberIndex(int index, ArrayList<Integer> list){
		int value = list.get(index-1);
		int smallestBiggerNumber = 1000;
		int indexOfSmallestBiggerNumber = 1000;
		for(int i = index; i < list.size(); i++){
			if(value < list.get(i) && list.get(i) < smallestBiggerNumber){
				smallestBiggerNumber = list.get(i);
				indexOfSmallestBiggerNumber = i;
			}
		}
		
		return indexOfSmallestBiggerNumber;
	}
	
	/**
	 * 1000-digit Fibonacci number
	 */
	public static void solveProblemTwentyFive(){
		int index = 2;
		BigInteger previous = new BigInteger("1");
		BigInteger current = new BigInteger("1");
		
		while(current.toString().length() < 1000){
			BigInteger temp = current.add(previous);
			previous = current;
			current = temp;
			index++;
		}
		
		System.out.printf("The index of the first term in the Fibonacci sequence to contain 1000 digits is: %d\n", index);
	}
}