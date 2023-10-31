package racingcar.view;

import racingcar.constant.OutputMessage;

public interface OutputView {
    void print(String message);
    default void print(OutputMessage outputMessage) {
        print(outputMessage.getMessage());
    }
}
