package racingcar.domain.game.car;

import racingcar.domain.dto.CarMovementDto;

public class Car {
    private final CarName carName;
    private int position = 0;

    protected Car(CarName carName) {
        this.carName = carName;
    }

    public static Car from(CarName carName) {
        return new Car(carName);
    }

    public void moveOnce() {
        position++;
    }

    public CarMovementDto toCarMovementDto() {
        return new CarMovementDto(carName, position);
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isSameAs(int maxPosition) {
        return position == maxPosition;
    }
}
