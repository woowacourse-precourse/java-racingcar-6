package racingcar.model;

public class Car {

    private final CarName name;
    private CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String carName) {
        CarName name = CarName.from(carName);
        CarPosition position = CarPosition.initialPosition();
        return new Car(name, position);
    }

    public CarName getName() {
        return name;
    }
}
