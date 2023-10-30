package racingcar.domain;

public class Car {
    private final CarName name;
    private CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), CarPosition.zero());
    }

    public String nameValue() {
        return name.value();
    }

    public int positionValue() {
        return position.value();
    }
}
