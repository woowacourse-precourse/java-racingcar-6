package racingcar.domain;

public class RacingCar {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        if (!isValid(name)) {
            throw new IllegalArgumentException("Name " + name + " is too long, max length = " + NAME_MAX_LENGTH);
        }
        this.name = name;
    }

    private boolean isValid(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }
}
