package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final int INITIAL_POSITION = 0;
    private final int FORWARD_CONDITION_NUMBER = 4;
    private static final int VALID_CAR_NAME_MAX_LENGTH = 5;

    public Car(String name) {
        checkCarNameLengthValid(name);
        checkCarNameEmpty(name);
        checkCarNameContainsWhiteSpace(name);

        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void forwardOrStay(int condition) {
        if (condition >= FORWARD_CONDITION_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static void checkCarNameLengthValid(String carName) {
        if (carName.length() > VALID_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameEmpty(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameContainsWhiteSpace(String carName) {
        if (carName.length() != carName.trim().length()) {
            throw new IllegalArgumentException();
        }
    }

}
