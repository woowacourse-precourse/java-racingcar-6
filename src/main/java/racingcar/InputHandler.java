package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public Cars inputName() {
        return new Cars(Console.readLine());
    }

    public int inputRound() {
        String input = Console.readLine();
        InputValidator validator = new InputValidator();
        validator.roundNonInputValidate(input);
        validator.roundRegExValidate(input);

        return Integer.parseInt(input);
    }
}
