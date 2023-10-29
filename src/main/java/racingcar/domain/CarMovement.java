package racingcar.domain;

import racingcar.dto.Car;

/**
 * GameRound, GameCondition 나누기
 */
public class CarMovement {
    Car raceCar;
    private static final CarStore carStore = CarStore.getInstance();

    public CarMovement(Car car) {
        this.raceCar = car;
        decideMovement(raceCar);
    }

    private void decideMovement(Car car) {
        if (GameCondition.hasDriveCondition()) {
            Car driveCar = drive(raceCar);
            carStore.saveCarInfo(driveCar);
        }
    }

    public Car drive(Car currentCar) {
        return new Car(currentCar.id(), currentCar.name(), currentCar.position() + 1);
    }

    public Car Stop(Car currentCar) {
        return new Car(currentCar.id(), currentCar.name(), currentCar.position());
    }

    public Car car() {
        return raceCar;
    }
}
