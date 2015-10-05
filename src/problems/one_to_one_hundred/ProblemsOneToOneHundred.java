package problems.one_to_one_hundred;

import java.util.ArrayList;

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
		/*long num = 600851;
	    num *= 1000000;
	    num += 475143;
	    //num = 100;
	    
	    ArrayList<Long> primeList = new ArrayList<Long>();
	    primeList.add((long) 2);
	    for(long i = 2; i < num / 2; i++){
	    
	      if(num % i == 0 && num % 2 != 0){
	        boolean prime = true;
	        for(int j = 0; j < primeList.size(); j++){
	          if(i % primeList.get(j) == 0){
	            prime = false;
	          	j = primeList.size();
	          }
	        }
	        
	        if(prime){
	          System.out.printf("%d\n", i);
	          primeList.add(i);
	        }
	        
	      }
	    }
	    
	    System.out.printf("done\n");*/
		
		/*ArrayList<Long> primeList = new ArrayList<Long>();
		primeList.add((long) 2);
		for(long i = 3; i < 1000000; i+=2){
			boolean prime = true;
			for(int j = 0; j < primeList.size(); j++){
				if(i % primeList.get(j) == 0){
					prime = false;
				}
			}
			if(prime){
				primeList.add(i);
			}
		}
		
		for(int j = 0; j < primeList.size(); j++){
			System.out.printf("%5d,", primeList.get(j));
			if(j % 20 == 0)
				System.out.printf("\n");
		}*/
		
		boolean primeList[] = new boolean[10000];
		for(int i = 0; i < 10000; i+= 2){
			primeList[i] = false;
		}
		
		for(long i = 3; i < 1000; i+=2){
			long divisor = i;
			
			for(int j = (int) divisor; j < 10000; j+=(int) divisor){
				
			}
		}
	}
}
