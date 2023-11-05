package racingcar.data.car;

public class CarName {
    private final String name;
    private static final int LIMIT = 5;
    private static final String EMPTY_EXCEPTION = "CarName cannot be empty.";
    private static final String LONGER_THAN_LIMIT_EXCEPTION = "CarName should be no longer than ";

    public CarName(String name) {
        validateCarName(name, LIMIT);
        this.name = name;
    }

    public static void validateCarName(String name, int limit) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
        if (name.length() > limit) {
            throw new IllegalArgumentException(LONGER_THAN_LIMIT_EXCEPTION + limit + ".");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
