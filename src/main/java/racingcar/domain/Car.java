package racingcar.domain;

public class Car {

    private final CarName name;

    private Car(CarName name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name));
    }

    public String getName() {
        return name.getName();
    }
}
