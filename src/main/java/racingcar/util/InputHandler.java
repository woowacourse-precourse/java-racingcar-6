package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;

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
