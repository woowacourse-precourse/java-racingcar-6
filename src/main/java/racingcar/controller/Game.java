package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        String inputNames = InputView.inputNames();
        Cars cars = Cars.of(inputNames, ",");

        String inputAttemptCount = InputView.inputAttemptCount();
        int attemptCount;
        try {
            attemptCount = Integer.parseInt(inputAttemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0회 이상만 가능합니다.");
        }

        OutputView.printRaceStart();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            cars.race();
            List<Car> carList = cars.copyList();
            OutputView.printCars(carList);
        }

        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
        InputView.close();
    }
}
