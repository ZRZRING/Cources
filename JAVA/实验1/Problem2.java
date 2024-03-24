public class Problem2 {
    public static void main(String[] args) {
		int i = 0, ans = 0;
		while (i + 1 <= 1000) {
			i++;
			if (i % 3 == 0 && i % 7 == 0) {
				ans += i;
			}
		}
		System.out.println(ans);
    }
}