package racingcar.controller;

import racingcar.domain.CarNameManager;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.BlankValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BlankValidator blankValidator = new BlankValidator();
    private final CarNameManager carNameManager = new CarNameManager(blankValidator);
    private final Cars cars = new Cars();
    private final Racing racing = new Racing(cars, blankValidator);

    public void raceStart() {
        setUpRace();
        runRace();
        printRaceResults();
    }

    private void setUpRace() {
        addCarsToRace();
        setAttemptCountForRace();
    }

    private void addCarsToRace() {
        String carNamesInput = inputView.printCarNameRequest();
        List<String> carNames = carNameManager.processCarNames(carNamesInput);
        cars.addCars(carNames);
    }

    private void setAttemptCountForRace() {
        String attemptCount = inputView.printAttemptCountRequest();
        racing.validateAttemptCount(attemptCount);
        System.out.println();
    }

    private void runRace() {
        for (int i = 0; i < racing.getAttempCount(); i++) {
            racing.race();
            outputView.printExecutionResult(cars.getCars());
            System.out.println();
        }
    }

    private void printRaceResults() {
        outputView.printResultText();
        outputView.printFinalWinner(cars.determineFinalWinner());
    }
}

