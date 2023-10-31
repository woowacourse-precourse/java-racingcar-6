package domain;

public class Car implements Comparable<Car>{
    private static final int INITIAL_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
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
