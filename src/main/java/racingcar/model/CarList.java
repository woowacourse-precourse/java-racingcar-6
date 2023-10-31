package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();


    public void addCar(Car car) {
        carList.add(car);
    }

    public int getNumberOfCars() {
        return carList.size();
    }

    public List<Car> provideRacingCars() {
        return carList;
    }

    public void updateCarsPosition(List<Boolean> movementResult) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).calculatePosition(movementResult.get(i));
        }
    }
}
