package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return input;
    }
}
