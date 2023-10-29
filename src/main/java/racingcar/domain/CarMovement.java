package racingcar.domain;

import racingcar.dto.Car;

public class CarMovement {
    Car raceCar;
    private static final CarStore carStore = CarStore.getInstance();

    public CarMovement(Car car) {
        this.raceCar = car;
        decideMovement();
    }

    private void decideMovement() {
        if (GameCondition.hasDriveCondition()) {
            Car driveCar = drive(raceCar);
            carStore.saveCarInfo(driveCar);
        }
    }

    private Car drive(Car currentCar) {
        return new Car(currentCar.name(), currentCar.position() + 1);
    }

    private Car Stop(Car currentCar) {
        return new Car(currentCar.name(), currentCar.position());
    }

    public Car car() {
        return raceCar;
    }
}
