package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private Cars cars;
    private static CarService instance;

    private CarService() {

    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService();
        }
        return instance;
    }

    public void generateCarsInstance(String carNames) {
        cars = Cars.getInstance(generateCarInstanceByCarName(carNames));
    }

    private List<Car> generateCarInstanceByCarName(String carNames) {
        // stream으로 바꿔보기
        List<Car> carList = new ArrayList<>();
        for (String carName : splitCarNames(carNames)) {
            carList.add(Car.newInstance(carName));
        }
        return carList;
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    public void tryRacing() {
        cars.racingCar();
    }

    public String getRacingResult() {
        return cars.getRacingResult();
    }

    public String getWinner() {
        return cars.getWinner();
    }
}
