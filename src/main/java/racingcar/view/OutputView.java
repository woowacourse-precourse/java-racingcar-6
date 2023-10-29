package racingcar.view;

import racingcar.message.ProcessMessage;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(ProcessMessage.INPUT_NAME);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(ProcessMessage.INPUT_ATTEMPT_COUNT);
    }
}
