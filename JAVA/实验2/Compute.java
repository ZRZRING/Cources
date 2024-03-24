// Triangle class
class Triangle {
    double[] side = new double[3];

    // Constructor
    Triangle(double[] side) {
        this.side[3] = side[3];
    }

    // Method to calculate perimeter
    double calculatePerimeter() {
        return side[0] + side[1] + side[2];
    }
}

// Ladder class
class Ladder {
    double upperBase;
    double lowerBase;
    double height;

    // Constructor
    Ladder(double upperBase, double lowerBase, double height) {
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
    }

    // Method to calculate area
    double calculateArea() {
        return (upperBase + lowerBase) * height / 2;
    }
}

// Circle class
class Circle {
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

// Compute class
public class Compute {
    // Method to compute area or perimeter based on the object type
    static double computeShape(Object shape) {
        if (shape instanceof Triangle) {
            return ((Triangle) shape).calculatePerimeter();
        } else if (shape instanceof Ladder) {
            return ((Ladder) shape).calculateArea();
        } else if (shape instanceof Circle) {
            return ((Circle) shape).calculateArea();
        } else {
            return 0; // Default return if shape is not recognized
        }
    }
}