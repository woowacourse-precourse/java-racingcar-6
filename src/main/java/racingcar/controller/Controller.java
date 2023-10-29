package racingcar.controller;

import java.util.List;
import racingcar.dto.AttemptCount;
import racingcar.dto.CurrentResult;
import racingcar.dto.ResultMessage;
import racingcar.model.Cars;
import racingcar.validator.AttemptCountValidator;
import racingcar.view.View;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        Cars cars = generateCars();
        attemptForward(cars, setAttemptCount());
        printWinners(cars);
    }

    private Cars generateCars() {
        view.printNameInputMessage();
        return createCars(readFromConsole());
    }

    private Cars createCars(String inputCars) {
        return new Cars(inputCars);
    }

    private int setAttemptCount() {
        view.printAttemptCountInputMessage();
        return creatAttemptCount(readFromConsole());
    }

    private int creatAttemptCount(String input) {
        AttemptCountValidator validator = AttemptCountValidator.INSTANCE;
        AttemptCount attemptCount = validator.validate(input);
        return attemptCount.getAttemptCount();
    }

    private String readFromConsole() {
        return view.inputConsole();
    }

    private void attemptForward(Cars cars, int count) {
        view.printAttemptResultMessage();

        for (int current = 0; current < count; current++) {
            cars.attemptForward();
            view.printCurrentCarsResult(getCurrentResult(cars));
        }
    }

    private List<CurrentResult> getCurrentResult(Cars cars) {
        return cars.getCurrentCarsResult();
    }

    private void printWinners(Cars cars) {
        view.printFinalWinnerMessage(getResultMessage(cars));
    }

    private ResultMessage getResultMessage(Cars cars) {
        return cars.findWinners();
    }
}
