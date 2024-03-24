import java.util.*;

class Student {
	private String title;
    private String name;
    private String group;
    private String id;
    private String loginDate;

    public Student(String title, String name, String group, String id, String loginDate) {
        this.title = title;
		this.name = name;
		this.group = group;
        this.id = id;
        this.loginDate = loginDate;
    }
	
	public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

	public String getGroup() {
		return group;
	}

    public String getId() {
        return id;
    }

    public String getLoginDate() {
        return loginDate;
    }

    @Override
    public String toString() {
        return title + ", " + name + ", " + group + ", " + id + ", " + loginDate;
    }
}

public class p6 {
	public static void main(String[] args) {
        Scanner scanner3 = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        while (scanner3.hasNextLine()) {
            String line = scanner3.nextLine();
            String[] parts = line.split(",");
            if (parts.length >= 4) {
				String title = parts[0];
                String name = parts[1];
				String group = parts[2];
                String id = parts[3];
                String loginDate = parts[4];
                students.add(new Student(title, name, group, id, loginDate));
            }
        }
        scanner3.close();
        students.sort(Comparator.comparing(Student::getId));
        System.out.println("按学号升序排列的学生：");
        for (Student student : students) {
            System.out.println(student);
        }
	}
}
