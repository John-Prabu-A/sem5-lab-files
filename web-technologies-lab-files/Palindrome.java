class Palindrome {
	static int Reverse(int n) {
		int result = 0;
		while (n != 0) {
			int digit = n % 10;
			result = result * 10 + digit;
			n /=10;
		}
		return result;
	}
	static boolean IsPalindrome(int n) {
		if(n == Reverse(n)) return true;
		else return false;
	}
	public static void main(String args[]) {
		for(int i = 1000; i > 0; --i) {
			if(IsPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
}
