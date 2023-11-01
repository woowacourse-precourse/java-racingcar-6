package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.model.AttemptCountValidator;
import racingcar.model.CarNameValidator;
import racingcar.model.RealRandomGenerator;
import racingcar.view.CarNameInput;
import racingcar.view.RacingAttemptInput;

public class RacingController {

    private CarNameInput carNameInput;
    private RacingGame racingGame;

    public RacingController(CarNameInput carNameInput) {
        this.carNameInput = carNameInput;
    }

    public void playRacingGame() {

        List<String> carNames = getValidCarNames();
        int attemptCount = getValidAttemptCount();

        initializeGame(carNames);
        executeRacingGame(attemptCount);
    }

    private void executeRacingGame(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racingGame.race();
            printRaceResults(racingGame.getCars());
        }
        racingGame.printWinners();
    }

    private void initializeGame(List<String> carNames) {
        racingGame = new RacingGame(carNames, new RealRandomGenerator());
    }

    private static int getValidAttemptCount() {
        RacingAttemptInput attemptInput = new RacingAttemptInput();
        attemptInput.requestAttemptCount();
        String input = attemptInput.readUserInput();
        return AttemptCountValidator.validateAttemptCount(input);

    }

    private List<String> getValidCarNames() {
        carNameInput.requestCarNames();
        String carNamesInput = carNameInput.getUserCarNames();
        List<String> carNames = carNameInput.parseCarNames(carNamesInput);
        CarNameValidator.validateCarNames(carNames);
        return carNames;
    }

    private void printRaceResults(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.display()));
        System.out.println();
    }
}


