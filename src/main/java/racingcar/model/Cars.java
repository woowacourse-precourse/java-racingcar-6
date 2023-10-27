package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> racingCars = new ArrayList<>();

    public void addCar(Car car) {
        racingCars.add(car);
    }

    public void updateCarsPosition(boolean moveResult) {
        for (Car car : racingCars) {
            car.calculatePosition(moveResult);
        }
    }

}
