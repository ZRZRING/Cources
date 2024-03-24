import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入圆柱体的高度：");
        double height = scanner.nextDouble();
        System.out.print("请输入圆柱体的底面半径：");
        double radius = scanner.nextDouble();
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("圆柱体的体积为：" + volume);
		scanner.close();
    }
}