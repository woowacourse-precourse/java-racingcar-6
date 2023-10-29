package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCarGame;
import racingcar.util.SeparationUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private final SeparationUtil separationUtil = new SeparationUtil();
    private final RacingCarGame racingCarGame = new RacingCarGame();

    List<Car> cars = new ArrayList<>();

    public void createCar(String carNames) {
        List<String> separatedCarNames = separateCarName(carNames);

        for (String separatedCarName : separatedCarNames) {
            Car car = new Car(separatedCarName);
            cars.add(car);
        }
    }

    public void setCount(String inputNumber) {
        racingCarGame.setCount(parseStringToInt(inputNumber));
    }

    private int parseStringToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    private List<String> separateCarName(String carNames) {
        return separationUtil.separationCarName(carNames);
    }

}
