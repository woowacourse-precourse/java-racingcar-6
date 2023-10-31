package racingcar.domain;

public class Car {
    private Car(String name) {
        this.name = name;
    }
    public static Car create(String name) {
        validateCarName(name);
        return new Car(name);
    }

    private final String name;

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
