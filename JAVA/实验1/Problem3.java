public class Problem3 {
	public static void main(String[] args) {
		int ans = 0;
		for (long i = 1, j = 8; i <= 10; i++, j = j * 10 + 8) {
			ans += j;
		}
		System.out.println(ans);
	}
}
