package racingcar.model;

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

    public String race() {
        String finalResult = "\n실행결과\n";
        for (int i = 0; i < tryCount; ++i) {
            String resultOfRound = Round.race(cars);
            finalResult += resultOfRound;
        }
        return finalResult;
    }

    public String getWinners() {
        return WinnerCalculator.getWinners(cars);
    }

    private void initCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
