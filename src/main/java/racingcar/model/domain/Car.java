package racingcar.model.domain;

public class Car {
    private final String name;
    private Integer location = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
