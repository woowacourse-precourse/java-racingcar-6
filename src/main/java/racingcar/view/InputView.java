package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return input;
    }

    public static String inputTryCount() {
        String input = Console.readLine();
        TryCountValidator.validate(input);
        return input;
    }
}
