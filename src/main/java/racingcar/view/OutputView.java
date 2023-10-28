package racingcar.view;

import racingcar.constant.OutputMessage;

public class OutputView {

    public void printNameMessage() {
        System.out.println(OutputMessage.READ_NAME.getMessage());
    }

    public void printTryCountMessage() {
        System.out.println(OutputMessage.READ_TRYCOUNT.getMessage());
    }
}
