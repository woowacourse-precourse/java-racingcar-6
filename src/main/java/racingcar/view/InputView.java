package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.utils.InputValidator;

public class InputView {
    public static String input() {
        return Console.readLine();
    }

    public static int nextInt() {
        return InputValidator.validateInputNumber(Console.readLine());
    }
}
