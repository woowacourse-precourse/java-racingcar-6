package domain;

public class Car implements Comparable<Car>{
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    public void go() {
        position++;
    }

    public void stop() {
        return;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }
}
