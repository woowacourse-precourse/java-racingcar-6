package racingcar.model;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String carName;

    private CarName(String input) {
        carName = validate(input);
    }

    public static CarName create(String input) {
        return new CarName(input);
    }

    private static String validate(String input) {
        if (input.isEmpty() || input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String getCarName() {
        return carName;
    }
}
