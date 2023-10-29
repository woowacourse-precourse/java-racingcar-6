package racingcar.domain;

public class Car {

    private final CarName name;
    private final CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

}
