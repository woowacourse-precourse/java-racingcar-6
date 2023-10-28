package racingcar.domain;

/**
 * GameRound, GameCondition 나누기
 */
public class CarMovement {
    private static final CarStore carStore = CarStore.getInstance();

    public CarMovement(Car raceCar) {
        decideMovement(raceCar);
    }

    private void decideMovement(Car raceCar) {
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
}
