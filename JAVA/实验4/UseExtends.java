class Mother {
	int height;
	double weight;
	int age;

	public void work() {
		System.out.println("妈妈正在工作");
	}

	public void housework() {
		System.out.println("妈妈正在做家务");
	}
}

class Daughter extends Mother {
	String hobby;

	public void get_hobby() {
		System.out.println("我喜欢看动画片");
	}
}

public class UseExtends {
	public static void main(String[] args) {
		System.out.println("测试继承类（女儿）");
		Daughter daughter = new Daughter();
		daughter.hobby = "跳舞";
		System.out.println("女儿的爱好是：" + daughter.hobby);
		daughter.get_hobby();
		daughter.age = 20;
		daughter.height = 150;
		daughter.weight = 100;
		System.out.println("我的年龄是：" + daughter.age + '\n' + "我的身高是：" + daughter.height + '\n' + "我的体重是：" + daughter.weight);
		System.out.println("测试父类（妈妈）:");
		daughter.work();
		daughter.housework();
	}
}