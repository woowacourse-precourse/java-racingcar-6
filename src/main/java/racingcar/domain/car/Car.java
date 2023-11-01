package racingcar.domain.car;

import racingcar.domain.dto.CarMovementDto;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private int position = 0;

    private Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(CarName carName) {
        return new Car(carName);
    }

    public void moveOnce() {
        position++;
    }

    public CarMovementDto toCarMovementDto() {
        return new CarMovementDto(getCarName(), position);
    }

    public String getCarName() {
        return carName.getName();
    }

    public boolean isSameAs(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }
}
