class Instrument<E> {
    public void play(E x) {
        System.out.println(x.toString() + " is playing...");
    }
}

class Cello {
    @Override
    public String toString() {
        return "Cello";
    }
}

class Violin {
    @Override
    public String toString() {
        return "Violin";
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Instrument<Cello> cello = new Instrument<>();
        cello.play(new Cello());
        Instrument<Violin> violin = new Instrument<>();
        violin.play(new Violin());
    }
}