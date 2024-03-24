class Instrument {
    public void play() {
        System.out.println("Instrument");
    }
}

class Piano extends Instrument {
    public void play() {
        System.out.println("钢琴演奏");
    }
}

class Violin extends Instrument {
    public void play() {
        System.out.println("小提琴演奏");
    }
}

class Cello extends Instrument {
    public void play() {
        System.out.println("大提琴演奏");
    }
}

public class InstrumentTest {
    public static void main(String[] args) {
        Instrument piano = new Piano();
        piano.play();
        Instrument violin = new Violin();
        violin.play();
        Instrument cello = new Cello();
        cello.play();
    }
}