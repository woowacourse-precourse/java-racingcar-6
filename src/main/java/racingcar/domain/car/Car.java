package racingcar.domain.car;

import java.util.Comparator;

public class Car {
    public static final Comparator<Car> COMPARATOR_BY_POSITION =
            Comparator.comparing((Car car) -> car.carPosition);

    private final DriveStrategy driveStrategy;
    private final CarName carName;
    private final CarPosition carPosition;

    private Car(DriveStrategy driveStrategy, CarName carName, CarPosition carPosition) {
        this.driveStrategy = driveStrategy;
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car createOnStart(DriveStrategy driveStrategy, String carName) {
        return new Car(driveStrategy, new CarName(carName), CarPosition.createStartPosition());
    }

    public static Car create(Car car) {
        return new Car(car.driveStrategy, car.carName, CarPosition.create(car.carPosition));
    }

    public void drive() {
        carPosition.move(driveStrategy.determineDistance());
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
