package com.sei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	public int[] randomIntegers = new int[] { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11,
			16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17,
			16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/*
	 *  In the below method, I m using a HashSet to remove the duplicates from the int array.
	 *  As HashSet doesn't allow duplicates, this is the simplest way to remove the duplicates, 
	 *  but using this approach we cannot maintain the order of insertion
	 *  
	 *  The time complexity of adding or retrieving from the HastSet is always O(1)
	 */
	public int[] removeDuplicatesUsingHashSet() {
		System.out.println("Method 1");
		Set<Integer> integerSet = new HashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) {
			integerSet.add(randomIntegers[i]);
		}
		/*
		 * Iterator<Integer> it = integerSet.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */

		Integer[] intArray = integerSet.toArray(new Integer[integerSet.size()]);

		// Using Java 8 Streams API, it is simpler to convert Integer[] to int[]
		return Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
	}

	
	/*
	 *  In the below method, I m using a HashSet to remove the duplicates from the int array.
	 *  As HashSet doesn't allow duplicates, this is the simplest way to remove the duplicates, but using this approach we cannot maintain the order of insertion.
	 *  For maintaining the insertion order, I have used the LinkedhashSet.
	 *  
	 *  The time complexity of adding or retrieving from the LinkedHastSet is always O(1)
	 */
	public int[] removeDuplicatesUsingLinkedHashSet() {

		System.out.println("Method 2");
		Set<Integer> integerSet = new LinkedHashSet<Integer>();

		for (int i = 0; i < randomIntegers.length; i++) {
			integerSet.add(randomIntegers[i]);
		}

		Integer[] intArray = integerSet.toArray(new Integer[integerSet.size()]);

		return Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
	}
	
	public int[] removeDuplicates() { 
        int end = randomIntegers.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (randomIntegers[i] == randomIntegers[j]) {                  
                    int shiftLeft = j;

                    for(int k = j + 1; k < end; k++, shiftLeft++) {
                    	randomIntegers[shiftLeft] = randomIntegers[k];
                    }

                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];

        for (int i = 0; i < end; i++) {
            whitelist[i] = randomIntegers[i];
        }

        return whitelist;
    }

	public static void main(String args[]) {
		DeDup deDup = new DeDup();
		
		int[] firstList = deDup.removeDuplicatesUsingHashSet();
		
		int[] secondList = deDup.removeDuplicatesUsingLinkedHashSet();
		
		int[] thirdList = deDup.removeDuplicates();
		
	}

}
