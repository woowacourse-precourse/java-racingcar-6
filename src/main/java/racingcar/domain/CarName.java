package racingcar.domain;

public class CarName {
    private static final int MAXIMUM_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
