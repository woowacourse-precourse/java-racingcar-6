package racingcar.controller;

import static racingcar.utils.Utils.convertStringToList;
import static racingcar.view.InputView.inputCarsName;

import java.util.List;
import racingcar.model.Cars;

public class RacingGameController {
    private int gameCount;
    private Cars cars;

    public void startGame() {
        List<String> carNameList = convertStringToList(inputCarsName());

    }
}
