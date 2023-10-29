package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class CarGame {
    private InputView inputView;

    public CarGame() {
        inputView = new InputView();
    }

    private void start() {
        String input = getCarNamesInput();
    }

    private String getCarNamesInput() {
        inputView.printInputCarName();
        String input = Console.readLine().trim();
        return checkCarNamesInput(input);
    }

    private String checkCarNamesInput(String input) {
        try {
            InputValidator.isNullOrIsEmpty(input);
            InputValidator.includeNumberOrSymbol(input);
            InputValidator.includeSpace(input);
        } catch (IllegalArgumentException e) {
            getCarNamesInput();
        }
        return input;
    }
}
