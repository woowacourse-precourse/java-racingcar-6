package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }
    public List<Car> getCarList() {
        return carList;
    }
    public int getCarCount() {
        return carList.size();
    }
}
