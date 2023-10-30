package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String readCarNames() {
        String input = Console.readLine();
        Validator.validateCarNames(input);
        return input;
    }

    public static int readNumberOfAttempts() {
        String input = Console.readLine();
        Validator.validateNumberOfAttempts(input);
        int numberOfAttempts = Integer.parseInt(input);
        return numberOfAttempts;
    }
}