package domain;

import constant.ExceptionMessage;

public class Car implements Comparable<Car>{
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int INITIAL_POSITION = 0;
    public static final int MINIMUM_INITIAL_POSITION = 0;
    public static final int MAXIMUM_INITIAL_POSITION = 9;
    public static final int STANDARD_FOR_GO = 4;

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
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEEDED.getMessage());
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
