import java.util.*;

public class p3 {
    private static int[] removeZeros(int[] arr) {
        return Arrays.stream(arr).filter(x -> x != 0).toArray();
    }

	public static void main(String[] args) {
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        int[] newArr = removeZeros(oldArr);
        System.out.println("去除0后的新数组：" + Arrays.toString(newArr));
	}
}
