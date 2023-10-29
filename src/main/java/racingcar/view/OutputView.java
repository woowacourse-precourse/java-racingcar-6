package racingcar.view;

import racingcar.util.Message;

public class OutputView {
    public OutputView() {
    }

    public static OutputView getInstance() {

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
