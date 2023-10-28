package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    public List<Car> carList = new ArrayList<>();

    public void save(String carName) {
        carList.add(new Car(carName));
    }

    public void moveForward(Car car) {
        car.move();
    }
}
