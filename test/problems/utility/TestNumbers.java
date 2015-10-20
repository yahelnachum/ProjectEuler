package problems.utility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestNumbers {

	@Test
	public void testGetDivisors() {
		ArrayList<Integer> divs1 = Numbers.getDivisors(10);
		
		assertEquals(divs1.size(), 3);
		assertEquals(divs1.get(0).intValue(), 1);
		assertEquals(divs1.get(1).intValue(), 2);
		assertEquals(divs1.get(2).intValue(), 5);
		
		ArrayList<Integer> divs2 = Numbers.getDivisors(25);
		
		assertEquals(divs2.size(), 2);
		assertEquals(divs2.get(0).intValue(), 1);
		assertEquals(divs2.get(1).intValue(), 5);
	}
	
	@Test
	public void testIsAbundant() {
		boolean abundant28 = Numbers.isAbundant(28);
		boolean abundant12 = Numbers.isAbundant(12);
		boolean abundant5 = Numbers.isAbundant(5);
		boolean abundant100 = Numbers.isAbundant(100);
		
		assertEquals(abundant28, false);
		assertEquals(abundant12, true);
		assertEquals(abundant5, false);
		assertEquals(abundant100, true);
	}
	
	@Test
	public void testNumberIsSumOfTwoAbundantNumbers() {
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++){
			if(Numbers.isAbundant(i)){
				abundantNumbers.add(i);
			}
		}
		
		assertEquals(Numbers.numberIsSumOfTwoAbundantNumbers(24, abundantNumbers), true);
		assertEquals(Numbers.numberIsSumOfTwoAbundantNumbers(23, abundantNumbers), false);
		assertEquals(Numbers.numberIsSumOfTwoAbundantNumbers(30, abundantNumbers), true);
		assertEquals(Numbers.numberIsSumOfTwoAbundantNumbers(136, abundantNumbers), true);
	}
	
	@Test
	public void testSortArray() {
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(5);
		list0.add(4);
		list0.add(10);
		list0.add(12);
		list0.add(19);
		
		Numbers.sortArray(0, list0.size() - 1, list0);
		
		assertEquals(list0.get(0).intValue(), 4);
		assertEquals(list0.get(2).intValue(), 10);
		assertEquals(list0.get(4).intValue(), 19);
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(9);
		list1.add(8);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		
		Numbers.sortArray(2, list1.size() - 1, list1);
		
		assertEquals(list1.get(0).intValue(), 9);
		assertEquals(list1.get(2).intValue(), 5);
		assertEquals(list1.get(3).intValue(), 6);
		assertEquals(list1.get(4).intValue(), 7);
	}

}
