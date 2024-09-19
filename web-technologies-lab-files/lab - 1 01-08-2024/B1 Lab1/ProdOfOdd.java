import java.math.BigInteger;

class ProdOfOdd {
	public static void main(String args[]) {
		// 6.Write a java program to calculate the product of all odd numbers from 1 to 50.
		BigInteger result = BigInteger.ONE;
		for(int i = 2; i <50; i+=2) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		System.out.println("50! is = " + result);
	}
}
