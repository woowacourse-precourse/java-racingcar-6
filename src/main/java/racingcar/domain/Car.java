package racingcar.domain;

import racingcar.domain.driver.Driver;
import racingcar.dto.CarDTO;
import racingcar.vo.CarName;

public class Car {
    private final CarName name;
    private final Driver driver;
    private int position = 0;

    public Car(CarName name, Driver driver) {
        this.name = name;
        this.driver = driver;
    }

    public void move() {
        if (driver.drive()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public CarDTO toDTO() {
        return new CarDTO(name.getName(), position);
    }

    public boolean isSamePosition(int targetPosition) {
        return this.position == targetPosition;
    }
}
