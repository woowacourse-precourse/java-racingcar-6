package racingcar.controller;

import java.util.List;
import racingcar.domain.AttemptCountValidator;
import racingcar.domain.CarNameValidator;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.BlankValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BlankValidator blankValidator = new BlankValidator();
    private final CarNameValidator carNameValidator = new CarNameValidator(blankValidator);
    private final Cars cars = new Cars();
    private Racing racing;

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
        List<String> carNames = carNameValidator.processCarNames(carNamesInput);
        cars.addCars(carNames);
    }

    private void setAttemptCountForRace() {
        String attemptCountInput = inputView.printAttemptCountRequest();
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        int attemptCount = attemptCountValidator.getAttemptCount(attemptCountInput);
        racing = new Racing(cars, attemptCount);
        outputView.printEnterLine();
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


