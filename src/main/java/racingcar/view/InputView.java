package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveCountValidator;

public class InputView {

    private InputView() {
    }

    public static String inputCarNames() {
        String input = Console.readLine();
        CarNameValidator.validate(input);
        return input;
    }

    public static String inputMoveCount() {
        String input = Console.readLine();
        MoveCountValidator.validate(input);
        return input;
    }
}
