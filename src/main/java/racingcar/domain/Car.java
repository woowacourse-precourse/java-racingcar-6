package racingcar.domain;

public class Car {
    private String name;
    private Integer position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }
}
