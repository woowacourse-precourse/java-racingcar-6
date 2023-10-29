package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.CarValidator;
import racingcar.validation.UserInputValidator;

public class RacingCarController {

    public void start() {
        String userInput = askCarNames();
        UserInputValidator.validateUserInput(userInput);
        List<String> carNames = splitInputByComma(userInput);
        CarValidator.validateCarNameList(carNames);
    }

    public String askCarNames() {
        return Console.readLine();
    }

    public List<String> splitInputByComma(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

}
