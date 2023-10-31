package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private int tryCount;

    public void setCarNames(List<String> carNames) {
        InputValidator.validateCarsName(carNames);
        initCars(carNames);
    }

    public void setTryCount(int tryCount) {
        InputValidator.validateCount(tryCount);
        this.tryCount = tryCount;
    }

    private void initCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public String race() {
        for (Car car : cars) {
            int randomNum = getRandomNum();
            car.move(randomNum);
        }
        return CurrentResultMap.getCurrentResultMap(cars);
    }

    public String getWinners() {
        return WinnerCalculator.getWinners(cars);
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
