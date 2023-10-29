package racingcar.view;

import racingcar.constant.Message;

public interface OutputView {
    static OutputView consoleOutputView() {
        return new ConsoleOutputView();
    }
    void printMessage();
    void printMessage(String message);
    void printMessage(Message message);
}
