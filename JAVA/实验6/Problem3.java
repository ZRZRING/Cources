import java.util.*;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 72);
        studentScores.put("Charlie", 90);
        studentScores.put("David", 65);
        studentScores.put("Emily", 95);
        List<Student> students = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            students.add(new Student(entry.getKey(), entry.getValue()));
        }
        Collections.sort(students, Comparator.comparingInt(Student::getScore).reversed());
        System.out.println("前三名学生的名字：");
        for (int i = 0; i < Math.min(3, students.size()); i++) {
            System.out.println(students.get(i).getName());
        }
    }
}
