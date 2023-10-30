package racingcar.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public static void printMainMessage() {
        StringBuilder mainMessage = new StringBuilder();
        mainMessage.append("\n").append(Message.OUTPUT_MAIN_MESSAGE.message);
        System.out.println(mainMessage);
    }

    private enum Message {
        OUTPUT_MAIN_MESSAGE("실행 결과");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
