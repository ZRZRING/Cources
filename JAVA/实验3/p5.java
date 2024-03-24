import java.util.*;

public class p5 {
    private static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount >= 2;
    }

	public static void main(String[] args) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("请输入密码：");
        String password = scanner2.nextLine();
        if (isValidPassword(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
        scanner2.close();
	}
}
