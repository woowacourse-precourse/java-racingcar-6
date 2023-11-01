package racingcar.model.car;

import racingcar.config.AppConfig;

public class Car {
    private final CarId carId;
    private final CarName carName;
    private CarPosition carPosition;

    private Car(CarId carId, CarName carName) {
        this.carId = carId;
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public static Car of(int value, String name) {
        CarId carId = new CarId(value);
        CarName carName = new CarName(name);

        return new Car(carId, carName);
    }

    public void move(int distance) {
        carPosition.move(distance);
    }

    public int getCarId() {
        return carId.id();
    }
    public String getName() {
        return carName.name();
    }
    public int getPosition() {
        return carPosition.getPosition();
    }
}
