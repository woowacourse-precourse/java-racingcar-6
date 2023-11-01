package racingcar.domain;

public class Car {

    private static final int LIMIT_NAME_LENGTH = 5;
    private static final int THRESHOLD_TO_FORWARD = 4;
    private String name;
    private int location;

    public Car(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public int moves(int randomNumber) {
        if (randomNumber >= THRESHOLD_TO_FORWARD) {
            location++;
        }
        return location;
    }
}
