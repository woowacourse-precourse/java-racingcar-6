package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Car car;
    private Validator validator;

    public RacingCarGame() {
        car = new Car();
        validator = new Validator();
    }

    public List<String> splitCarNamesByComma() {
        String carName = InputView.getCarNameFromPlayer();
        String[] carNameArray = carName.split(",");

        List<String> carNameList = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) {
            carNameList.add(carNameArray[i]);
        }
        return carNameList;
    }

    public void moveCarForward() {
        for (String car : splitCarNamesByComma()) {
            OutputView.printExecutionResult(car);
        }
    }

    public void accumulateCarMoving() {
        String attempt = InputView.getNumberFromPlayer();
        int attemptNumber = Integer.parseInt(attempt);
        if (validator.isNumberFromPlayerValidate(attempt)) {
            for (int i = 0; i < attemptNumber; i++) {
                moveCarForward();
            }
        }
    }
}
