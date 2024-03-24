abstract class Geometry{
    public abstract double getArea();
}

class Pillar {
	Geometry bottom;
	private double height;

	Pillar(Geometry bottom, double height) {
		this.bottom = bottom;
		this.height = height;
	}

	public double getVolume() {
		return bottom.getArea() * this.height;
	}
}

class Rectangle extends Geometry {
	private double a, b;

	Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getArea() {
		return a * b;
	}
}

class Circle extends Geometry {
	private double r;

	Circle(double r) {
		this.r = r;
	}

	public double getArea() {
		return Math.PI * r * r;
	}
}

class Triangle extends Geometry {
	private double x, y;

	Triangle(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getArea() {
		return x * y / 2;
	}
}

public class PillarTest {
	public static void main(String[] args) {
		Pillar pillar;
		Geometry bottom;
		bottom = new Rectangle(4, 5);
		pillar = new Pillar(bottom, 6);
		System.out.println("长方体体积: " + pillar.getVolume());
		bottom = new Circle(5);
		pillar = new Pillar(bottom, 6);
		System.out.println("圆柱体体积: " + pillar.getVolume());
		bottom = new Triangle(3, 4);
		pillar = new Pillar(bottom, 6);
		System.out.println("三角形体积: " + pillar.getVolume());
	}
}