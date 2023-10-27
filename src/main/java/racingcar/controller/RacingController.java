package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.EmptyValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    EmptyValidator emptyValidator = new EmptyValidator();
    Cars cars = new Cars(emptyValidator);
    Racing racing = new Racing(cars, emptyValidator);

    public void raceStart() {
        cars.addCars(inputView.printCarNameRequest());
        racing.validateAttemptCount(inputView.printAttemptCountRequest());
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
