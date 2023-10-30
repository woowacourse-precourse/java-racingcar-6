package domain;

public class Car implements Comparable<Car>{
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
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
