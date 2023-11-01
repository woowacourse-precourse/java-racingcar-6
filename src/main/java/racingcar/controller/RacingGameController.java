package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RaceResult;
import racingcar.domain.RacingGame;
import racingcar.util.InputValidator;
import racingcar.util.InvalidCustomException;
import racingcar.view.RacingGameView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    public void run() {
        String[] carNames = RacingGameView.getCarNames();
        int totalAttempts = RacingGameView.getTotalAttempts();

        if (!InputValidator.validateCarNames(carNames) || !InputValidator.validateTotalAttempts(totalAttempts)) {
            throw new InvalidCustomException("잘못된 입력 값입니다.");
        }

        List<Car> cars = initializeCars(carNames);
        RacingGame racingGame = new RacingGame(cars);

        for (int attempt = 0; attempt < totalAttempts; attempt++) {
            racingGame.startRace();
            racingGame.calculateResult();
            RacingGameView.printRaceResult(generateRaceResultStrings(cars));
        }

        RaceResult result = racingGame.calculateResult();
        RacingGameView.printWinners(result.getWinners());

    }

    private List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private List<String> generateRaceResultStrings(List<Car> cars) {
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.getName() + " : " + car.getPositionString());
        }
        return results;
    }
}
