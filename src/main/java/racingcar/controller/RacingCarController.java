package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.UserInputValidator;

public class RacingCarController {

    public void start() {
        String userInput = askCarNames();
        UserInputValidator.validateUserInput(userInput);
    }

    public String askCarNames() {
        return Console.readLine();
    }

}
