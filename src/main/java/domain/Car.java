package domain;

public class Car {

    private static final int START_POSITION = 0;

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_NAME_LENGTH = 2;

    private static final String SEPERATOR = " : ";

    private static final String POSITION_STRING = "-";

    private final String name;

    private final CarEngine carEngine;

    private int position;

    public Car(final String name, final CarEngine carEngine) {
        this.name = name;
        this.carEngine = carEngine;
        this.position = START_POSITION;
        validateName();
    }

    private void validateName() {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (carEngine.canMoveForward()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + SEPERATOR + POSITION_STRING.repeat(position);
    }
}
