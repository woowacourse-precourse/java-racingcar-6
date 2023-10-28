package racingcar.model;

import java.util.*;

public class Cars {
    List<Car> racingCars = new ArrayList<>();

    public void addCar(Car car) {
        racingCars.add(car);
    }

    public int getNumberOfCars() {
        return racingCars.size();
    }

    public void updateCarsPosition(List<Boolean> moveResult) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).calculatePosition(moveResult.get(i));
        }
    }
}
