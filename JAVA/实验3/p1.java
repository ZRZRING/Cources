import java.util.*;

public class p1 {
    public static void main(String[] args) {
        char[] chars = {'a', 'd', 'm', 'z', 'h', 'c', 'o'};
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }
}