public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new double[]{5.0, 5.0, 5.0});
        System.out.println("Triangle perimeter: " + Compute.computeShape(triangle));

        Ladder ladder = new Ladder(4, 6, 3);
        System.out.println("Ladder area: " + Compute.computeShape(ladder));

        Circle circle = new Circle(2.5);
        System.out.println("Circle area: " + Compute.computeShape(circle));
        System.out.println("Circle circumference: " + circle.calculateCircumference());

        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);

        student student1 = new student(1, "zrzring", "Male", 20, 85.5);
        student student2 = new student(2, "Silver Wolf", "Female", 22, 90.0);

        System.out.println("\nStudent 1 Information:");
        student1.print();
        System.out.println("\nStudent 2 Information:");
        student2.print();
    }
}
