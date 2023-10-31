package racingcar.domain.car;

import java.util.Comparator;

public class Car {
    public static final Comparator<Car> COMPARATOR_BY_POSITION =
            Comparator.comparing((Car car) -> car.carPosition);

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
        carPosition.move(driveBehavior.determineDistance());
    }

    public boolean isSamePosition(Car car) {
        return carPosition.equals(car.carPosition);
    }

    public String getName() {
        return carName.name();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }
}
