package Java实验6;

public class 第一问 {
    public static void main(String[] args) {
        // 创建 Cello 对象并演奏
        Cello cello = new Cello();
        cello.play("Bow");

        // 创建 Violin 对象并演奏
        Violin violin = new Violin();
        violin.play(1); // 假设这里使用整数1代表某种演奏技巧或状态
    }

}
// 泛型类 Instrument
class Instrument<E> {
    // 泛型方法 play
    public void play(E x) {
        System.out.println("Playing the instrument with " + x);
    }
}

// Cello 类，继承自 Instrument<String>
 class Cello extends Instrument<String> {
    // Cello 类的其他方法或属性...
}

// Violin 类，继承自 Instrument<Integer>
 class Violin extends Instrument<Integer> {
    // Violin 类的其他方法或属性...
}



