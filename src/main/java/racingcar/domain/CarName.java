package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
