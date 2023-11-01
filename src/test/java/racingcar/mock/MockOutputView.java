package racingcar.mock;

import racingcar.view.OutputView;

public class MockOutputView implements OutputView {
    private static final MockOutputView instance = new MockOutputView();
    private String printedMessage = "";

    public static MockOutputView getInstance() {
        return instance;
    }

    @Override
    public void print(String message) {
        printedMessage += message;
        printedMessage += "\n";

        System.out.println(message);
    }

    public String getPrintedMessageAndClear() {
        String result = printedMessage;
        printedMessage = "";
        return result;
    }
}
