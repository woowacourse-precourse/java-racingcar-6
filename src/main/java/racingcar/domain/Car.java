package racingcar.domain;

public class Car {
    private String name;
    private Integer count;

    private Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }
}
