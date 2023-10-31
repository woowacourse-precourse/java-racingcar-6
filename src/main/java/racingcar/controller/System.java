package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.attempt.AttemptCount;
import racingcar.model.car.Cars;
import racingcar.util.InputValidation;
import racingcar.view.InputView;

public class System {
    private static final String NAME_DELIMITER = ",";
    private final InputView inputView;
    private Cars cars;
    private AttemptCount attemptCount;
    private boolean validInput;

    public System(InputView inputView) {
        this.inputView = inputView;
    }


    public Cars createCars() {
        validInput = true;
        while (validInput) {
            inputCars();
        }
        return cars;
    }

    private void inputCars() {
        inputView.alertInputNames();
        List<String> carNames = Arrays.stream(readLine().split(NAME_DELIMITER))
                .collect(Collectors.toList());
        try {
            carNames.forEach(InputValidation::validateCarNameLength);
            cars = new Cars(carNames);
            validInput = false;
        } catch (Exception exception) {
            inputView.printErrorMessage(exception.getMessage());
        }
    }

    public AttemptCount createAttemptCount() {
        validInput = true;
        while (validInput) {
            inputCount();
        }
        return attemptCount;
    }

    private void inputCount() {
        inputView.alertInputCountOfAttempt();
        String attemptCountInput = readLine();
        try {
            InputValidation.validateUserInputNumberRange(attemptCountInput);
            InputValidation.validateUserInputNumberFormat(attemptCountInput);
            attemptCount = new AttemptCount(attemptCountInput);
            validInput = false;
        } catch (Exception exception) {
            inputView.printErrorMessage(exception.getMessage());
        }
    }
}
