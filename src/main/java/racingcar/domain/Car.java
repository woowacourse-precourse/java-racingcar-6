package racingcar.domain;

import racingcar.domain.driver.Driver;
import racingcar.dto.CarDTO;
import racingcar.vo.CarName;

public class Car implements Comparable<Car> {
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

    public CarDTO toDTO() {
        return new CarDTO(name.getName(), position);
    }

    public boolean isSamePosition(Car car) {
        return compareTo(car) == 0;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.position);
    }

}