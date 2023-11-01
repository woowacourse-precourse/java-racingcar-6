package racingcar.view.printer;

public class MockPrinter implements Printer {

    private String printedMessage = "";

    @Override
    public void print(String message) {
        printedMessage = printedMessage.concat(message);
    }

    public String getPrintedMessage() {
        return printedMessage;
    }
}
