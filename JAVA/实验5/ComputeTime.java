// 定义Common接口
interface Common {
    double calculateSpeed();
}

// 定义Car类实现Common接口
class Car implements Common {
    private double A;
    private double B;
    private double C;

    public Car(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public double calculateSpeed() {
        return A * B / C;
    }
}

// 定义Plane类实现Common接口
class Plane implements Common {
    private double A;
    private double B;
    private double C;

    public Plane(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public double calculateSpeed() {
        return A + B + C;
    }
}

// 测试程序
public class ComputeTime {
    public static double calculateTime(Common common, double distance) {
        double speed = common.calculateSpeed();
        return distance / speed;
    }
	
    public static void main(String[] args) {
        Car car = new Car(60, 2, 3); // 参数A=60, B=2, C=3
        Plane plane = new Plane(300, 200, 100); // 参数A=300, B=200, C=100

        double distance = 1000;

        // 计算Car运行1000公里所需的时间
        double carTime = ComputeTime.calculateTime(car, distance);
        System.out.println("Car运行1000公里所需的时间：" + carTime + " 小时");

        // 计算Plane运行1000公里所需的时间
        double planeTime = ComputeTime.calculateTime(plane, distance);
        System.out.println("Plane运行1000公里所需的时间：" + planeTime + " 小时");
    }
}
