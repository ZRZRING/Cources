import java.util.LinkedList;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input 10 numbers:");
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			int x = scanner.nextInt();
			list.add(x);
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}
}