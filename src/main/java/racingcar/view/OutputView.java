package racingcar.view;

import racingcar.constant.ViewMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printlnViewMessage(ViewMessage message) {
        System.out.println(message.toString());
    }

    public static void printlnResult(String result) {
        System.out.println(result);
    }
}
