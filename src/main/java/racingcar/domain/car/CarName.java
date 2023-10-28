package racingcar.domain.car;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
        validateMaxLength(name);
        return new CarName(name);
    }

    private static void validateMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Name of Car length should less than or equal to %d".formatted(MAX_NAME_LENGTH)
            );
        }
    }

}
