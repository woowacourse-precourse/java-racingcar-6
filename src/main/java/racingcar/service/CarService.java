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

    public void generateCarsInstance(String carNames) {
        cars = Cars.getInstance(generateCarInstanceByCarName(carNames));
    }

    private List<Car> generateCarInstanceByCarName(String carNames) {
        // stream으로 바꿔보기
        List<Car> carList = new ArrayList<>();
        for (String carName : splitCarNames(carNames)) {
            carList.add(Car.getInstance(carName));
        }
        return carList;
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
