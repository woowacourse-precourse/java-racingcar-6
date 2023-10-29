package racingcar.io.output;

public class ConsoleWriter {

    public void printCarNameInputGuide() {
        printLine(OutputMessage.CAR_NAME_INPUT_GUIDE.getLiteral());
    }

    public void printMovingCountInputGuide() {
        printLine(OutputMessage.MOVING_COUNT_INPUT_GUIDE.getLiteral());
    }

    private void printLine(String message) {
        System.out.println(message);
    }

}
