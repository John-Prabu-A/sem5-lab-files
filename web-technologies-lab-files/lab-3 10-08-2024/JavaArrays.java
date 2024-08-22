public class JavaArrays {
	public static void main(String args[]) {
		// basic array
		int[] normalArr1 = {1, 2, 3, 4, 5};
		int[] normalArr2 = new int[5];
		for(int i = 0; i < 5; i++) normalArr2[i] = i+6;
		System.out.println("\nArr 1 : ");
		printArr(normalArr1);
		System.out.println("\nArr 2 : ");
		printArr(normalArr2);

		// multi Array
		int[][] multiArr = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		System.out.println("\nMulti Array : ");
		printMultiArr(multiArr);

		// jagged Array
		int[][] jaggedArr = new int[3][];
		jaggedArr[0] = new int[] {1, 2};
		jaggedArr[1] = new int[] {3, 4, 5};
		jaggedArr[2] = new int[] {6, 7, 8, 9};

		System.out.println("\nJagged Array : ");
		printMultiArr(jaggedArr);

		// Anonymous Array
		System.out.println("\nAnonymous Array : ");
		printArr(new int[] {10, 20, 30, 40, 50});

		// Array methods
		int[] arr = {5, 2, 8, 3, 9, 1};
		
		// => Accessing Element
		System.out.println("\nElement at index 2 is " + arr[2]);

		// => modifying Element
		System.out.println("\nchanging arr[2] = 10 ...");
		arr[2] = 10;
		System.out.println("Modified Array : ");
		printArr(arr);

		// => Lenght property
		System.out.println("\nLenght of the given Array is " + arr.length);

		// => Sorting array Java.util.Arrays.sort(<array>);
		java.util.Arrays.sort(arr);
		System.out.println("\nSorted Array : ");
		printArr(arr);

		// => Searching an element java.util.Arrays.binarySearch(<array>, Obj <key>) -> return index || -1;
		int index = java.util.Arrays.binarySearch(arr, 10);
		System.out.println("\nAfter binary Search element 10 present at index " + index);

		// => copying array
		int[] copiedArr = java.util.Arrays.copyOf(arr, arr.length);
		System.out.println("\nCopied Array : ");

		// => comparing Array
		boolean areEqual = java.util.Arrays.equals(arr, copiedArr);
		System.out.println("Are original and copied array are equal : " + (areEqual ? "YES" : "NO"));
		// => filling array with constant
		java.util.Arrays.fill(copiedArr, 7);
		System.out.println("\nArray after fill 7 : ");
		printArr(copiedArr);

	}

	// method to print single dimentional array
	private static void printArr(int[] arr) {
		for(int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	// method to print 2D array
	private static void printMultiArr(int[][] arr) {
		for(int [] row : arr) {
			for(int elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}
}


