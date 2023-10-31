package racingcar.model;


public class Car {
    private static final int MIN_NUMBER_FOR_MOVE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

