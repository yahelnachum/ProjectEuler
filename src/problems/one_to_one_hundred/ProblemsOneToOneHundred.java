package problems.one_to_one_hundred;

import java.math.BigInteger;

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
			solveProblemThriteen();
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
	
	public static int getNumberOfDivisors(long number){
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
	
	public static void solveProblemThriteen(){
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
	
	public static void printEvery10Number(long array[]){
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
}

