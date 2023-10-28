package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String readCarNames() {
        String input = Console.readLine();
        Validator.validateCarNames(input);
        return input;
    }
}
