package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String readCarNames() {
        String userInput = Console.readLine();
        Validator.validateCarNames(userInput);
        return userInput;
    }

    public static int readNumberOfAttempts() {
        String userInput = Console.readLine();
        Validator.validateNumberOfAttempts(userInput);
        int numberOfAttempts = Integer.parseInt(userInput);
        return numberOfAttempts;
    }
}