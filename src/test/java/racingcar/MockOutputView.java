package racingcar;

import racingcar.view.OutputView;

public class MockOutputView implements OutputView {
    private static final MockOutputView INSTANCE = new MockOutputView();
    private String printedMessage = "";

    public static MockOutputView getInstance() {
        return INSTANCE;
    }

    @Override
    public void print(String message) {
        printedMessage += message;
        printedMessage += "\n";

        System.out.println(message);
    }

    public String getPrintedMessageAndClear() {
        printedMessage = "";
        return printedMessage;
    }
}
