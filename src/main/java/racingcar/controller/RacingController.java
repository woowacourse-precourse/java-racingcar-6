package racingcar.controller;

import java.util.List;
import racingcar.domain.AttemptCountValidator;
import racingcar.domain.CarNameManager;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.BlankValidator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BlankValidator blankValidator = new BlankValidator();
    private final CarNameManager carNameManager = new CarNameManager(blankValidator);
    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
    private final RandomNumberGenerator randomNumberGenerator;
    private final Cars cars = new Cars();
    private int attemptCount;
    private Racing racing;
    public RacingController(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

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
        carNameManager.validateCarNames(carNames);
        cars.addCars(carNames);
    }

    private void setAttemptCountForRace() {
        String attemptCountInput = inputView.printAttemptCountRequest();
        this.attemptCount = attemptCountValidator.getAttemptCount(attemptCountInput);
        racing = new Racing(cars, randomNumberGenerator);
        outputView.printEnterLine();
    }

    private void runRace() {
        outputView.printResultText();
        for (int i = 0; i < this.attemptCount; i++) {
            racing.race();
            outputView.printExecutionResult(cars.getCars());
            System.out.println();
        }
    }

    private void printRaceResults() {
        outputView.printFinalWinner(cars.determineFinalWinner());
    }
}


