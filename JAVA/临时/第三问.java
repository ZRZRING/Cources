package Java实验6;
import java.util.*;

class Student {
    private String studentId;
    private String name;
    private int score;

    public Student(String studentId, String name, int score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class 第三问 {
    public static void main(String[] args) {
        // 定义Map来存储学生信息，键为学号，值为Student对象
        Map<String, Student> studentsMap = new HashMap<>();

        // 录入学生信息
        studentsMap.put("001", new Student("001", "Alice", 95));
        studentsMap.put("002", new Student("002", "Bob", 87));
        studentsMap.put("003", new Student("003", "Charlie", 96));
        studentsMap.put("004", new Student("004", "David", 25));

        // 按分数降序显示学生名字
        List<Student> sortedStudents = new ArrayList<>(studentsMap.values());
        Collections.sort(sortedStudents, Comparator.comparing(Student::getScore).reversed());

        System.out.println("Students sorted by score in descending order:");
        for (Student student : sortedStudents) {
            System.out.println("- " + student.getName());
        }
    }
}
