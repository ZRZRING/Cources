import java.util.*;

public class p4 {
    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(200) + 1;
        }
        return arr;
    }

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度：");
        int n = scanner.nextInt();
        scanner.close();
        int[] randomArr = generateRandomArray(n);
        Arrays.sort(randomArr);
        System.out.println("排序后的数组：" + Arrays.toString(randomArr));
        int searchNumber = 55;
        if (Arrays.binarySearch(randomArr, searchNumber) >= 0) {
            System.out.println("数组中包含整数55。");
        } else {
            System.out.println("数组中不包含整数55。");
        }
	}
}
