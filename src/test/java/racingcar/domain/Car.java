package racingcar.domain;

public class Car {
    private final int position;
    private final String name;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }
}
