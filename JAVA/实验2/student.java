public class student {
    private int studentId;
    private String name;
    private String gender;
    private int age;
    private double averageGrade;

    // Constructor
    public student(int studentId, String name, String gender, int age, double averageGrade) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    // Setter methods
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    // Method to print student information
    public void print() {
        System.out.println("student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Average Grade: " + averageGrade);
    }
}