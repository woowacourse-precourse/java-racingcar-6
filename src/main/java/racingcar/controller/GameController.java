package racingcar.controller;

import java.util.List;
import racingcar.validator.CarNamesInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(new CarNamesInputValidator());
        outputView.askToInsertCarNames();
        List<String> carNames = inputView.getCarNamesFromUser();
        carNames.forEach(System.out::println);
    }
}