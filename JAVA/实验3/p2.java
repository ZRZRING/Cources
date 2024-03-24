import java.util.*;

public class p2 {
    private static void sortByScore(String[] names, int[] scores) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], scores[i]);
        }
        Arrays.sort(names, Comparator.comparing(map::get).reversed());
    }

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生数量：");
        int numStudents = scanner.nextInt();
        String[] names = new String[numStudents];
        int[] scores = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("请输入学生姓名：");
            names[i] = scanner.next();
            System.out.print("请输入学生成绩：");
            scores[i] = scanner.nextInt();
        }
        scanner.close();
        sortByScore(names, scores);
        System.out.println("按成绩降序排列的学生姓名：");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(names[i] + ": " + scores[i]);
        }
	}
}