package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private Cars cars;

    private CarService() {

    }

    public static CarService getInstance() {
        return new CarService();
    }

    public void generateCarAndCarsInstanceFromCarNames(String carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : splitCarNames(carNames)) {
            carList.add(Car.getInstance(carName));
        }
        cars = Cars.getInstance(carList);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }


}
