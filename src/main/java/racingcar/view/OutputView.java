package racingcar.view;

import racingcar.constant.Message;

public interface OutputView {
    void printMessage();
    void printMessage(String message);
    void printMessage(Message message);
}
