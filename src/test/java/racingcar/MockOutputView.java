package racingcar;

import racingcar.view.OutputView;

public class MockOutputView implements OutputView {
    private String printedMessage = "";

    @Override
    public void print(String message) {
        printedMessage += message;
        printedMessage += "\n";

        System.out.println(message);
    }

    public String getPrintedMessage() {
        return printedMessage;
    }
}
