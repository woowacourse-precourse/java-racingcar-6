package racingcar.domain;

public class Car {
    public static final int INITIAL_POSITION = 0;
    public static final int FORWARD_CONDITION_NUMBER = 4;
    public static final int VALID_CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int position;


    public Car(String name) {
        checkCarNameEmpty(name);
        checkCarNameLengthValid(name);
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

    public void checkCarNameLengthValid(String carName) {
        if (carName.length() > VALID_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCarNameEmpty(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCarNameContainsWhiteSpace(String carName) {
        if (carName.length() != carName.replace(" ", "").length()) {
            throw new IllegalArgumentException();
        }
    }

}
