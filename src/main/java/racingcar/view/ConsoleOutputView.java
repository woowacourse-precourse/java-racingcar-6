package racingcar.view;

import racingcar.constant.Message;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printEmptyLine() {
        System.out.println();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printMessage(Message message) {
        System.out.println(message.getValue());
    }
}
