package racingcar;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Car name must not be null and not longer than 5 characters.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

