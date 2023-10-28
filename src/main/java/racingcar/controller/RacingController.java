package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.BlankValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BlankValidator blankValidator = new BlankValidator();
    Cars cars = new Cars(blankValidator);
    Racing racing = new Racing(cars, blankValidator);

    public void raceStart() {
        cars.addCars(inputView.printCarNameRequest());
        racing.validateAttemptCount(inputView.printAttemptCountRequest());
        System.out.println();
        outputView.printResultText();
        executeRaces();
        outputView.printFinalWinner(cars.determineFinalWinner());
    }

    private void executeRaces() {
        for (int i = 0; i < racing.getAttempCount(); i++) {
            racing.race();
            outputView.printExecutionResult(cars.getCars());
            System.out.println();
        }
    }
}
