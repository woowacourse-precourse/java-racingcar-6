package racingcar.view;

import racingcar.util.MessageUtil;

public class OutputView {
    public void printCarNameInputMessage() {
        MessageUtil.CAR_NAME_INPUT_MESSAGE.messagePrintln();
    }

    public void printTryCountInputMessage() {
        MessageUtil.TRY_COUNT_INPUT_MESSAGE.messagePrintln();
    }

    public void printCarNameAndPosition(String carNameAndPosition) {
        System.out.println(carNameAndPosition);
    }

    public void printNewLine() {
        System.out.println();
    }
}
