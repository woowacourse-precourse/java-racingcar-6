package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

public class CarService {
    private static final String NAME_SEPARATOR = ",";
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
        return Arrays.stream(splitCarNames(carNames))
                .map(Car::newInstance)
                .toList();
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(NAME_SEPARATOR);
    }

    public void tryRacing() {
        cars.racingCar();
    }

    public String getRacingResult() {
        return cars.getRacingResult();
    }

    public String getWinner() {
        return cars.getRacingWinner();
    }
}
