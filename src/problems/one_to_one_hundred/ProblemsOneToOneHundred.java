package problems.one_to_one_hundred;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import problems.data_structures.StringScorer;
import problems.data_structures.TriangleNode;
import problems.utility.FileInput;
import problems.utility.Numbers;

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
		case 13:
			solveProblemThirteen();
			break;
		case 14:
			solveProblemFourteen();
			break;
		case 15:
			solveProblemFifteen();
			break;
		case 16:
			solveProblemSixteen();
			break;
		case 17:
			solveProblemSeventeen();
			break;
		case 18:
			solveProblemEighteen();
			break;
		case 19:
			solveProblemNineteen();
			break;
		case 20:
			solveProblemTwenty();
			break;
		case 21:
			solveProblemTwentyOne();
			break;
		case 22:
			solveProblemTwentyTwo();
			break;
		case 23:
			solveProblemTwentyThree();
			break;
		case 24:
			solveProblemTwentyFour();
			break;
		case 25:
			solveProblemTwentyFive();
			break;
		case 67:
			solveProblemSixtySeven();
			break;
		}
		
	}
	
	private static void solveProblemOne(){
		int sum = 0;
		int highestNumber = 1000;
		
		for(int i = 1; i < highestNumber; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		
		System.out.printf("Answer to problem 1 is: %d", sum);
	}
	
	private static void solveProblemTwo(){
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
	
	private static void solveProblemThree(){

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

	private static void solveProblemFour(){
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

	private static void solveProblemFive(){
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

	private static void solveProblemSix(){
		int sumOfSquares = 0;
		int squareOfSums = 0;
		
		for(int i = 1; i < 101; i++){
			sumOfSquares += i*i;
			squareOfSums += i;
		}
		
		squareOfSums *= squareOfSums;
		
		System.out.printf("The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum: %d\n", squareOfSums - sumOfSquares);
	}

	private static void solveProblemSeven(){
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

	private static void solveProblemEight(){
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

	private static void solveProblemNine(){
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

	private static void solveProblemTen(){
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

	private static void solveProblemEleven(){
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
		
		System.out.printf("Greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20�20 grid is: %d\n", largestProduct);
	}

	private static void solveProblemTwelve(){
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
	
	private static void solveProblemThirteen(){
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
	
	private static void solveProblemFourteen(){
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
	
	private static void solveProblemFifteen(){
		long pascalTriangleRow[] = getPascalTriangleRow(41);
		System.out.printf("Routes there are through a 20�20 grid: %d\n", pascalTriangleRow[pascalTriangleRow.length / 2]);
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
	
	public static void solveProblemSixtySeven(){
		int[][] triangleInt = { {59},
								{73,41},
								{52,40, 9},
								{26,53,06,34},
								{10,51,87,86,81},
								{61,95,66,57,25,68},
								{90,81,80,38,92,67,73},
								{30,28,51,76,81,18,75,44},
								{84,14,95,87,62,81,17,78,58},
								{21,46,71,58,02,79,62,39,31, 9},
								{56,34,35,53,78,31,81,18,90,93,15},
								{78,53,04,21,84,93,32,13,97,11,37,51},
								{45,03,81,79,05,18,78,86,13,30,63,99,95},
								{39,87,96,28,03,38,42,17,82,87,58,07,22,57},
								{06,17,51,17,07,93, 9,07,75,97,95,78,87, 8,53},
								{67,66,59,60,88,99,94,65,55,77,55,34,27,53,78,28},
								{76,40,41,04,87,16, 9,42,75,69,23,97,30,60,10,79,87},
								{12,10,44,26,21,36,32,84,98,60,13,12,36,16,63,31,91,35},
								{70,39,06,05,55,27,38,48,28,22,34,35,62,62,15,14,94,89,86},
								{66,56,68,84,96,21,34,34,34,81,62,40,65,54,62,05,98,03,02,60},
								{38,89,46,37,99,54,34,53,36,14,70,26,02,90,45,13,31,61,83,73,47},
								{36,10,63,96,60,49,41,05,37,42,14,58,84,93,96,17, 9,43,05,43,06,59},
								{66,57,87,57,61,28,37,51,84,73,79,15,39,95,88,87,43,39,11,86,77,74,18},
								{54,42,05,79,30,49,99,73,46,37,50,02,45, 9,54,52,27,95,27,65,19,45,26,45},
								{71,39,17,78,76,29,52,90,18,99,78,19,35,62,71,19,23,65,93,85,49,33,75, 9,02},
								{33,24,47,61,60,55,32,88,57,55,91,54,46,57,07,77,98,52,80,99,24,25,46,78,79,05},
								{92, 9,13,55,10,67,26,78,76,82,63,49,51,31,24,68,05,57,07,54,69,21,67,43,17,63,12},
								{24,59,06, 8,98,74,66,26,61,60,13,03, 9, 9,24,30,71, 8,88,70,72,70,29,90,11,82,41,34},
								{66,82,67,04,36,60,92,77,91,85,62,49,59,61,30,90,29,94,26,41,89,04,53,22,83,41, 9,74,90},
								{48,28,26,37,28,52,77,26,51,32,18,98,79,36,62,13,17, 8,19,54,89,29,73,68,42,14, 8,16,70,37},
								{37,60,69,70,72,71, 9,59,13,60,38,13,57,36, 9,30,43,89,30,39,15,02,44,73,05,73,26,63,56,86,12},
								{55,55,85,50,62,99,84,77,28,85,03,21,27,22,19,26,82,69,54,04,13,07,85,14,01,15,70,59,89,95,10,19},
								{04, 9,31,92,91,38,92,86,98,75,21,05,64,42,62,84,36,20,73,42,21,23,22,51,51,79,25,45,85,53,03,43,22},
								{75,63,02,49,14,12,89,14,60,78,92,16,44,82,38,30,72,11,46,52,90,27, 8,65,78,03,85,41,57,79,39,52,33,48},
								{78,27,56,56,39,13,19,43,86,72,58,95,39,07,04,34,21,98,39,15,39,84,89,69,84,46,37,57,59,35,59,50,26,15,93},
								{42,89,36,27,78,91,24,11,17,41,05,94,07,69,51,96,03,96,47,90,90,45,91,20,50,56,10,32,36,49,04,53,85,92,25,65},
								{52, 9,61,30,61,97,66,21,96,92,98,90,06,34,96,60,32,69,68,33,75,84,18,31,71,50,84,63,03,03,19,11,28,42,75,45,45},
								{61,31,61,68,96,34,49,39,05,71,76,59,62,67,06,47,96,99,34,21,32,47,52,07,71,60,42,72,94,56,82,83,84,40,94,87,82,46},
								{01,20,60,14,17,38,26,78,66,81,45,95,18,51,98,81,48,16,53,88,37,52,69,95,72,93,22,34,98,20,54,27,73,61,56,63,60,34,63},
								{93,42,94,83,47,61,27,51,79,79,45,01,44,73,31,70,83,42,88,25,53,51,30,15,65,94,80,44,61,84,12,77,02,62,02,65,94,42,14,94},
								{32,73, 9,67,68,29,74,98,10,19,85,48,38,31,85,67,53,93,93,77,47,67,39,72,94,53,18,43,77,40,78,32,29,59,24,06,02,83,50,60,66},
								{32,01,44,30,16,51,15,81,98,15,10,62,86,79,50,62,45,60,70,38,31,85,65,61,64,06,69,84,14,22,56,43, 9,48,66,69,83,91,60,40,36,61},
								{92,48,22,99,15,95,64,43,01,16,94,02,99,19,17,69,11,58,97,56,89,31,77,45,67,96,12,73, 8,20,36,47,81,44,50,64,68,85,40,81,85,52, 9},
								{91,35,92,45,32,84,62,15,19,64,21,66,06,01,52,80,62,59,12,25,88,28,91,50,40,16,22,99,92,79,87,51,21,77,74,77,07,42,38,42,74,83,02,05},
								{46,19,77,66,24,18,05,32,02,84,31,99,92,58,96,72,91,36,62,99,55,29,53,42,12,37,26,58,89,50,66,19,82,75,12,48,24,87,91,85,02,07,03,76,86},
								{99,98,84,93,07,17,33,61,92,20,66,60,24,66,40,30,67,05,37,29,24,96,03,27,70,62,13,04,45,47,59,88,43,20,66,15,46,92,30,04,71,66,78,70,53,99},
								{67,60,38,06,88,04,17,72,10,99,71,07,42,25,54,05,26,64,91,50,45,71,06,30,67,48,69,82, 8,56,80,67,18,46,66,63,01,20, 8,80,47,07,91,16,03,79,87},
								{18,54,78,49,80,48,77,40,68,23,60,88,58,80,33,57,11,69,55,53,64,02,94,49,60,92,16,35,81,21,82,96,25,24,96,18,02,05,49,03,50,77,06,32,84,27,18,38},
								{68,01,50,04,03,21,42,94,53,24,89,05,92,26,52,36,68,11,85,01,04,42,02,45,15,06,50,04,53,73,25,74,81,88,98,21,67,84,79,97,99,20,95,04,40,46,02,58,87},
								{94,10,02,78,88,52,21,03,88,60,06,53,49,71,20,91,12,65,07,49,21,22,11,41,58,99,36,16, 9,48,17,24,52,36,23,15,72,16,84,56,02,99,43,76,81,71,29,39,49,17},
								{64,39,59,84,86,16,17,66,03, 9,43,06,64,18,63,29,68,06,23,07,87,14,26,35,17,12,98,41,53,64,78,18,98,27,28,84,80,67,75,62,10,11,76,90,54,10,05,54,41,39,66},
								{43,83,18,37,32,31,52,29,95,47, 8,76,35,11,04,53,35,43,34,10,52,57,12,36,20,39,40,55,78,44,07,31,38,26, 8,15,56,88,86,01,52,62,10,24,32,05,60,65,53,28,57,99},
								{03,50,03,52,07,73,49,92,66,80,01,46, 8,67,25,36,73,93,07,42,25,53,13,96,76,83,87,90,54,89,78,22,78,91,73,51,69, 9,79,94,83,53, 9,40,69,62,10,79,49,47,03,81,30},
								{71,54,73,33,51,76,59,54,79,37,56,45,84,17,62,21,98,69,41,95,65,24,39,37,62,03,24,48,54,64,46,82,71,78,33,67, 9,16,96,68,52,74,79,68,32,21,13,78,96,60, 9,69,20,36},
								{73,26,21,44,46,38,17,83,65,98,07,23,52,46,61,97,33,13,60,31,70,15,36,77,31,58,56,93,75,68,21,36,69,53,90,75,25,82,39,50,65,94,29,30,11,33,11,13,96,02,56,47,07,49,02},
								{76,46,73,30,10,20,60,70,14,56,34,26,37,39,48,24,55,76,84,91,39,86,95,61,50,14,53,93,64,67,37,31,10,84,42,70,48,20,10,72,60,61,84,79,69,65,99,73,89,25,85,48,92,56,97,16},
								{03,14,80,27,22,30,44,27,67,75,79,32,51,54,81,29,65,14,19,04,13,82,04,91,43,40,12,52,29,99,07,76,60,25,01,07,61,71,37,92,40,47,99,66,57,01,43,44,22,40,53,53, 9,69,26,81,07},
								{49,80,56,90,93,87,47,13,75,28,87,23,72,79,32,18,27,20,28,10,37,59,21,18,70,04,79,96,03,31,45,71,81,06,14,18,17,05,31,50,92,79,23,47, 9,39,47,91,43,54,69,47,42,95,62,46,32,85},
								{37,18,62,85,87,28,64,05,77,51,47,26,30,65,05,70,65,75,59,80,42,52,25,20,44,10,92,17,71,95,52,14,77,13,24,55,11,65,26,91,01,30,63,15,49,48,41,17,67,47,03,68,20,90,98,32,04,40,68},
								{90,51,58,60,06,55,23,68,05,19,76,94,82,36,96,43,38,90,87,28,33,83,05,17,70,83,96,93,06,04,78,47,80,06,23,84,75,23,87,72,99,14,50,98,92,38,90,64,61,58,76,94,36,66,87,80,51,35,61,38},
								{57,95,64,06,53,36,82,51,40,33,47,14,07,98,78,65,39,58,53,06,50,53,04,69,40,68,36,69,75,78,75,60,03,32,39,24,74,47,26,90,13,40,44,71,90,76,51,24,36,50,25,45,70,80,61,80,61,43,90,64,11},
								{18,29,86,56,68,42,79,10,42,44,30,12,96,18,23,18,52,59,02,99,67,46,60,86,43,38,55,17,44,93,42,21,55,14,47,34,55,16,49,24,23,29,96,51,55,10,46,53,27,92,27,46,63,57,30,65,43,27,21,20,24,83},
								{81,72,93,19,69,52,48,01,13,83,92,69,20,48,69,59,20,62,05,42,28,89,90,99,32,72,84,17, 8,87,36,03,60,31,36,36,81,26,97,36,48,54,56,56,27,16,91, 8,23,11,87,99,33,47,02,14,44,73,70,99,43,35,33},
								{90,56,61,86,56,12,70,59,63,32,01,15,81,47,71,76,95,32,65,80,54,70,34,51,40,45,33,04,64,55,78,68,88,47,31,47,68,87,03,84,23,44,89,72,35, 8,31,76,63,26,90,85,96,67,65,91,19,14,17,86,04,71,32,95},
								{37,13,04,22,64,37,37,28,56,62,86,33,07,37,10,44,52,82,52,06,19,52,57,75,90,26,91,24,06,21,14,67,76,30,46,14,35,89,89,41,03,64,56,97,87,63,22,34,03,79,17,45,11,53,25,56,96,61,23,18,63,31,37,37,47},
								{77,23,26,70,72,76,77,04,28,64,71,69,14,85,96,54,95,48,06,62,99,83,86,77,97,75,71,66,30,19,57,90,33,01,60,61,14,12,90,99,32,77,56,41,18,14,87,49,10,14,90,64,18,50,21,74,14,16,88,05,45,73,82,47,74,44},
								{22,97,41,13,34,31,54,61,56,94,03,24,59,27,98,77,04, 9,37,40,12,26,87, 9,71,70,07,18,64,57,80,21,12,71,83,94,60,39,73,79,73,19,97,32,64,29,41,07,48,84,85,67,12,74,95,20,24,52,41,67,56,61,29,93,35,72,69},
								{72,23,63,66,01,11,07,30,52,56,95,16,65,26,83,90,50,74,60,18,16,48,43,77,37,11,99,98,30,94,91,26,62,73,45,12,87,73,47,27,01,88,66,99,21,41,95,80,02,53,23,32,61,48,32,43,43,83,14,66,95,91,19,81,80,67,25,88},
								{ 8,62,32,18,92,14,83,71,37,96,11,83,39,99,05,16,23,27,10,67,02,25,44,11,55,31,46,64,41,56,44,74,26,81,51,31,45,85,87, 9,81,95,22,28,76,69,46,48,64,87,67,76,27,89,31,11,74,16,62,03,60,94,42,47, 9,34,94,93,72},
								{56,18,90,18,42,17,42,32,14,86,06,53,33,95,99,35,29,15,44,20,49,59,25,54,34,59,84,21,23,54,35,90,78,16,93,13,37,88,54,19,86,67,68,55,66,84,65,42,98,37,87,56,33,28,58,38,28,38,66,27,52,21,81,15, 8,22,97,32,85,27},
								{91,53,40,28,13,34,91,25,01,63,50,37,22,49,71,58,32,28,30,18,68,94,23,83,63,62,94,76,80,41,90,22,82,52,29,12,18,56,10, 8,35,14,37,57,23,65,67,40,72,39,93,39,70,89,40,34,07,46,94,22,20,05,53,64,56,30,05,56,61,88,27},
								{23,95,11,12,37,69,68,24,66,10,87,70,43,50,75,07,62,41,83,58,95,93,89,79,45,39,02,22,05,22,95,43,62,11,68,29,17,40,26,44,25,71,87,16,70,85,19,25,59,94,90,41,41,80,61,70,55,60,84,33,95,76,42,63,15, 9,03,40,38,12,03,32},
								{ 9,84,56,80,61,55,85,97,16,94,82,94,98,57,84,30,84,48,93,90,71,05,95,90,73,17,30,98,40,64,65,89,07,79, 9,19,56,36,42,30,23,69,73,72,07,05,27,61,24,31,43,48,71,84,21,28,26,65,65,59,65,74,77,20,10,81,61,84,95, 8,52,23,70},
								{47,81,28, 9,98,51,67,64,35,51,59,36,92,82,77,65,80,24,72,53,22,07,27,10,21,28,30,22,48,82,80,48,56,20,14,43,18,25,50,95,90,31,77, 8, 9,48,44,80,90,22,93,45,82,17,13,96,25,26, 8,73,34,99,06,49,24,06,83,51,40,14,15,10,25,01},
								{54,25,10,81,30,64,24,74,75,80,36,75,82,60,22,69,72,91,45,67,03,62,79,54,89,74,44,83,64,96,66,73,44,30,74,50,37,05, 9,97,70,01,60,46,37,91,39,75,75,18,58,52,72,78,51,81,86,52, 8,97,01,46,43,66,98,62,81,18,70,93,73, 8,32,46,34},
								{96,80,82,07,59,71,92,53,19,20,88,66,03,26,26,10,24,27,50,82,94,73,63, 8,51,33,22,45,19,13,58,33,90,15,22,50,36,13,55,06,35,47,82,52,33,61,36,27,28,46,98,14,73,20,73,32,16,26,80,53,47,66,76,38,94,45,02,01,22,52,47,96,64,58,52,39},
								{88,46,23,39,74,63,81,64,20,90,33,33,76,55,58,26,10,46,42,26,74,74,12,83,32,43, 9,02,73,55,86,54,85,34,28,23,29,79,91,62,47,41,82,87,99,22,48,90,20,05,96,75,95,04,43,28,81,39,81,01,28,42,78,25,39,77,90,57,58,98,17,36,73,22,63,74,51},
								{29,39,74,94,95,78,64,24,38,86,63,87,93,06,70,92,22,16,80,64,29,52,20,27,23,50,14,13,87,15,72,96,81,22, 8,49,72,30,70,24,79,31,16,64,59,21,89,34,96,91,48,76,43,53,88,01,57,80,23,81,90,79,58,01,80,87,17,99,86,90,72,63,32,69,14,28,88,69},
								{37,17,71,95,56,93,71,35,43,45,04,98,92,94,84,96,11,30,31,27,31,60,92,03,48,05,98,91,86,94,35,90,90, 8,48,19,33,28,68,37,59,26,65,96,50,68,22,07, 9,49,34,31,77,49,43,06,75,17,81,87,61,79,52,26,27,72,29,50,07,98,86,01,17,10,46,64,24,18,56},
								{51,30,25,94,88,85,79,91,40,33,63,84,49,67,98,92,15,26,75,19,82,05,18,78,65,93,61,48,91,43,59,41,70,51,22,15,92,81,67,91,46,98,11,11,65,31,66,10,98,65,83,21,05,56,05,98,73,67,46,74,69,34, 8,30,05,52,07,98,32,95,30,94,65,50,24,63,28,81,99,57},
								{19,23,61,36, 9,89,71,98,65,17,30,29,89,26,79,74,94,11,44,48,97,54,81,55,39,66,69,45,28,47,13,86,15,76,74,70,84,32,36,33,79,20,78,14,41,47,89,28,81,05,99,66,81,86,38,26,06,25,13,60,54,55,23,53,27,05,89,25,23,11,13,54,59,54,56,34,16,24,53,44,06},
								{13,40,57,72,21,15,60, 8,04,19,11,98,34,45, 9,97,86,71,03,15,56,19,15,44,97,31,90,04,87,87,76, 8,12,30,24,62,84,28,12,85,82,53,99,52,13,94,06,65,97,86, 9,50,94,68,69,74,30,67,87,94,63,07,78,27,80,36,69,41,06,92,32,78,37,82,30,05,18,87,99,72,19,99},
								{44,20,55,77,69,91,27,31,28,81,80,27,02,07,97,23,95,98,12,25,75,29,47,71,07,47,78,39,41,59,27,76,13,15,66,61,68,35,69,86,16,53,67,63,99,85,41,56, 8,28,33,40,94,76,90,85,31,70,24,65,84,65,99,82,19,25,54,37,21,46,33,02,52,99,51,33,26,04,87,02, 8,18,96},
								{54,42,61,45,91,06,64,79,80,82,32,16,83,63,42,49,19,78,65,97,40,42,14,61,49,34,04,18,25,98,59,30,82,72,26,88,54,36,21,75,03,88,99,53,46,51,55,78,22,94,34,40,68,87,84,25,30,76,25, 8,92,84,42,61,40,38, 9,99,40,23,29,39,46,55,10,90,35,84,56,70,63,23,91,39},
								{52,92,03,71,89,07, 9,37,68,66,58,20,44,92,51,56,13,71,79,99,26,37,02,06,16,67,36,52,58,16,79,73,56,60,59,27,44,77,94,82,20,50,98,33, 9,87,94,37,40,83,64,83,58,85,17,76,53,02,83,52,22,27,39,20,48,92,45,21, 9,42,24,23,12,37,52,28,50,78,79,20,86,62,73,20,59},
								{54,96,80,15,91,90,99,70,10, 9,58,90,93,50,81,99,54,38,36,10,30,11,35,84,16,45,82,18,11,97,36,43,96,79,97,65,40,48,23,19,17,31,64,52,65,65,37,32,65,76,99,79,34,65,79,27,55,33,03,01,33,27,61,28,66, 8,04,70,49,46,48,83,01,45,19,96,13,81,14,21,31,79,93,85,50,05},
								{92,92,48,84,59,98,31,53,23,27,15,22,79,95,24,76,05,79,16,93,97,89,38,89,42,83,02,88,94,95,82,21,01,97,48,39,31,78, 9,65,50,56,97,61,01,07,65,27,21,23,14,15,80,97,44,78,49,35,33,45,81,74,34,05,31,57, 9,38,94,07,69,54,69,32,65,68,46,68,78,90,24,28,49,51,45,86,35},
								{41,63,89,76,87,31,86, 9,46,14,87,82,22,29,47,16,13,10,70,72,82,95,48,64,58,43,13,75,42,69,21,12,67,13,64,85,58,23,98, 9,37,76,05,22,31,12,66,50,29,99,86,72,45,25,10,28,19,06,90,43,29,31,67,79,46,25,74,14,97,35,76,37,65,46,23,82,06,22,30,76,93,66,94,17,96,13,20,72},
								{63,40,78, 8,52, 9,90,41,70,28,36,14,46,44,85,96,24,52,58,15,87,37,05,98,99,39,13,61,76,38,44,99,83,74,90,22,53,80,56,98,30,51,63,39,44,30,91,91,04,22,27,73,17,35,53,18,35,45,54,56,27,78,48,13,69,36,44,38,71,25,30,56,15,22,73,43,32,69,59,25,93,83,45,11,34,94,44,39,92},
								{12,36,56,88,13,96,16,12,55,54,11,47,19,78,17,17,68,81,77,51,42,55,99,85,66,27,81,79,93,42,65,61,69,74,14,01,18,56,12,01,58,37,91,22,42,66,83,25,19,04,96,41,25,45,18,69,96,88,36,93,10,12,98,32,44,83,83,04,72,91,04,27,73,07,34,37,71,60,59,31,01,54,54,44,96,93,83,36,04,45},
								{30,18,22,20,42,96,65,79,17,41,55,69,94,81,29,80,91,31,85,25,47,26,43,49,02,99,34,67,99,76,16,14,15,93, 8,32,99,44,61,77,67,50,43,55,87,55,53,72,17,46,62,25,50,99,73,05,93,48,17,31,70,80,59, 9,44,59,45,13,74,66,58,94,87,73,16,14,85,38,74,99,64,23,79,28,71,42,20,37,82,31,23},
								{51,96,39,65,46,71,56,13,29,68,53,86,45,33,51,49,12,91,21,21,76,85,02,17,98,15,46,12,60,21,88,30,92,83,44,59,42,50,27,88,46,86,94,73,45,54,23,24,14,10,94,21,20,34,23,51,04,83,99,75,90,63,60,16,22,33,83,70,11,32,10,50,29,30,83,46,11,05,31,17,86,42,49,01,44,63,28,60,07,78,95,40},
								{44,61,89,59,04,49,51,27,69,71,46,76,44,04, 9,34,56,39,15,06,94,91,75,90,65,27,56,23,74,06,23,33,36,69,14,39,05,34,35,57,33,22,76,46,56,10,61,65,98, 9,16,69,04,62,65,18,99,76,49,18,72,66,73,83,82,40,76,31,89,91,27,88,17,35,41,35,32,51,32,67,52,68,74,85,80,57,07,11,62,66,47,22,67},
								{65,37,19,97,26,17,16,24,24,17,50,37,64,82,24,36,32,11,68,34,69,31,32,89,79,93,96,68,49,90,14,23,04,04,67,99,81,74,70,74,36,96,68, 9,64,39,88,35,54,89,96,58,66,27,88,97,32,14,06,35,78,20,71,06,85,66,57,02,58,91,72,05,29,56,73,48,86,52, 9,93,22,57,79,42,12,01,31,68,17,59,63,76,07,77},
								{73,81,14,13,17,20,11, 9,01,83, 8,85,91,70,84,63,62,77,37,07,47,01,59,95,39,69,39,21,99, 9,87,02,97,16,92,36,74,71,90,66,33,73,73,75,52,91,11,12,26,53,05,26,26,48,61,50,90,65,01,87,42,47,74,35,22,73,24,26,56,70,52,05,48,41,31,18,83,27,21,39,80,85,26, 8,44,02,71,07,63,22,05,52,19, 8,20},
								{17,25,21,11,72,93,33,49,64,23,53,82,03,13,91,65,85,02,40,05,42,31,77,42,05,36,06,54,04,58,07,76,87,83,25,57,66,12,74,33,85,37,74,32,20,69,03,97,91,68,82,44,19,14,89,28,85,85,80,53,34,87,58,98,88,78,48,65,98,40,11,57,10,67,70,81,60,79,74,72,97,59,79,47,30,20,54,80,89,91,14,05,33,36,79,39},
								{60,85,59,39,60,07,57,76,77,92,06,35,15,72,23,41,45,52,95,18,64,79,86,53,56,31,69,11,91,31,84,50,44,82,22,81,41,40,30,42,30,91,48,94,74,76,64,58,74,25,96,57,14,19,03,99,28,83,15,75,99,01,89,85,79,50,03,95,32,67,44, 8,07,41,62,64,29,20,14,76,26,55,48,71,69,66,19,72,44,25,14,01,48,74,12,98,07},
								{64,66,84,24,18,16,27,48,20,14,47,69,30,86,48,40,23,16,61,21,51,50,26,47,35,33,91,28,78,64,43,68,04,79,51, 8,19,60,52,95,06,68,46,86,35,97,27,58,04,65,30,58,99,12,12,75,91,39,50,31,42,64,70,04,46,07,98,73,98,93,37,89,77,91,64,71,64,65,66,21,78,62,81,74,42,20,83,70,73,95,78,45,92,27,34,53,71,15},
								{30,11,85,31,34,71,13,48,05,14,44,03,19,67,23,73,19,57,06,90,94,72,57,69,81,62,59,68,88,57,55,69,49,13,07,87,97,80,89,05,71,05,05,26,38,40,16,62,45,99,18,38,98,24,21,26,62,74,69,04,85,57,77,35,58,67,91,79,79,57,86,28,66,34,72,51,76,78,36,95,63,90, 8,78,47,63,45,31,22,70,52,48,79,94,15,77,61,67,68},
								{23,33,44,81,80,92,93,75,94,88,23,61,39,76,22,03,28,94,32,06,49,65,41,34,18,23, 8,47,62,60,03,63,33,13,80,52,31,54,73,43,70,26,16,69,57,87,83,31,03,93,70,81,47,95,77,44,29,68,39,51,56,59,63,07,25,70,07,77,43,53,64,03,94,42,95,39,18,01,66,21,16,97,20,50,90,16,70,10,95,69,29,06,25,61,41,26,15,59,63,35}};
								
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
}

