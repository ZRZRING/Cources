class Aircraft extends Vehicle {
	public void state() {
		System.out.println("飞行类交通工具");
	}
}

class SpaceShuttle extends Aircraft {
	public void state() {
		System.out.println("飞行类交通工具中的航天飞机");
	}
}

class Jet extends Aircraft {
	public void state() {
		System.out.println("飞行类交通工具中的喷气式 飞机");
	}
}

public class Vehicle {
	public int speed;
	public String name;
	public String color;

	public void start() {
		System.out.println("起步");
	}

	public void stop() {
		System.out.println("停止");
	}

	public void run() {
		System.out.println("加速");
	}

	public static void main(String[] args) {
		Aircraft Aircraft1 = new Aircraft();
		Aircraft Aircraft2 = new Aircraft();
		Aircraft Aircraft3 = new SpaceShuttle();
		Aircraft Aircraft4 = new Jet();
		Aircraft1.start();
		Aircraft1.run();
		Aircraft2.stop();
		Aircraft1.state();
		Aircraft3.state();
		Aircraft4.state();
	}

}