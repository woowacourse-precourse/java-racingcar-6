package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarValidator;
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
            List<String> carNameList = splitCarNames(input);
            CarValidator.isOnlyLowerCase(carNameList);
            CarValidator.checkCarNameLength(carNameList);
            CarValidator.checkDuplicateCarName(carNameList);
        } catch (IllegalArgumentException e) {
            getCarNamesInput();
        }
        return input;
    }

    private List<String> splitCarNames(String input) {
        String[] nameArray = input.split(",");
        List<String> nameList = new ArrayList<>(Arrays.stream(nameArray).toList());
        return nameList;
    }
}
