package oracle.training.data;

public class ArraysExercices {

	public static void main(String[] args) {

		/**
		 * Fill values into index from 2 to 4 with aaa
		 */
//		String[] values = new String[5];
//		Arrays.fill(values, 2, 4, "aaa");
//		int x = Arrays.binarySearch(values, "aaa");

		/**
		 * Ø Combine declaration and creation of the array object
		 */
		int[] primes = new int[4];
		primes[1] = 3;
		primes[2] = 7;
		primes[0] = primes[1] - 1;

		/**
		 * Combine creation of the array object and initialisation of the array content
		 */
		int[] primes1 = new int[] { 1, 2, 3, 4, 5, 6 };

		/**
		 * Combine declaration and creation of the array objects as well as the
		 */
		int[] primes2 = { 2, 3, 5 };

		/**
		 * Multidimensional same matrix as matrix1 bellow but not so verbose
		 */
		int[][] matrix = { { 5, 9, 4 }, { 3, 11, 12 }, { 4, 3, 2 } };

//		int[][] matrix1 = new int[3][3];
//		matrix[0][0] = 5;
//		matrix[0][1] = 9;
//		matrix[0][2] = 4;
//		matrix[1][0] = 3;
//		matrix[1][1] = 11;
//		matrix[1][2] = 12;
//		matrix[2][0] = 4;
//		matrix[2][1] = 5;
//		matrix[2][2] = 5;

		/**
		 * Print a matrix using for loop and for each loop
		 */
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		StringBuilder txt = new StringBuilder();
		for (int[] row : matrix) {
			for ( int value : row) {
				System.out.println(value);
			}
		}
		/**
		 * Comparing content in arrays create class LengthCompare with a logic to
		 * compare
		 */

//		String[] names1 = {"Mary", "Ann", "Jane", "Tom"};
//		String[] names2 = {"Mary", "Ann", "Jhon", "Tom"};
//		boolean isTheSame = Arrays.equals(names1 , names2);
//		Arrays.sort(names2);
//		Arrays.sort(names2, new LengthCompare());

		/**
		 * Processing arrays using loops and append
		 */

		String[] values = { "B", "R", "U", "N", "O", };
		StringBuilder txt1 = new StringBuilder();
		for (String value : values) {
			System.out.println(value + " " + txt.append(value));
		}

	}
}
