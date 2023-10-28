package racingcar.service;

import racingcar.model.Car;
import racingcar.util.SeparationUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private final SeparationUtil separationUtil = new SeparationUtil();

    List<Car> cars = new ArrayList<>();

    public void createCar(String carNames) {
        List<String> separatedCarNames = separateCarName(carNames);

        for (String separatedCarName : separatedCarNames) {
            Car car = new Car(separatedCarName);
            cars.add(car);
        }
    }

    private List<String> separateCarName(String carNames) {
        return separationUtil.separationCarName(carNames);
    }

}
