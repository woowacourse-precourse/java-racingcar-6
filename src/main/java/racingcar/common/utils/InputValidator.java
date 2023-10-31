package racingcar.common.utils;

import racingcar.common.consts.SystemMessage;
import racingcar.view.OutputView;

public class InputValidator {
    public static int validateInputNumber(String number) {
        try {
            int n = Integer.parseInt(number);
            return n;
        } catch (NumberFormatException e) {
            OutputView.printErrMessage(SystemMessage.INVALID_INPUT_NUMBER_ERROR);
            throw new IllegalArgumentException(SystemMessage.INVALID_INPUT_NUMBER_ERROR);
        }
    }


}
