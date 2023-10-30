package racingcar.domain;

public class Car {
    private final DriveBehavior driveBehavior;
    private final CarName carName;
    private final CarPosition carPosition;

    private Car(DriveBehavior driveBehavior, CarName carName, CarPosition carPosition) {
        this.driveBehavior = driveBehavior;
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car createOnStart(DriveBehavior driveBehavior, String carName) {
        return new Car(driveBehavior, new CarName(carName), CarPosition.createStartPosition());
    }

    public static Car create(Car car) {
        return new Car(car.driveBehavior, car.carName, CarPosition.create(car.carPosition));
    }

    public void drive() {
        driveBehavior.drive(carPosition);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }
}
