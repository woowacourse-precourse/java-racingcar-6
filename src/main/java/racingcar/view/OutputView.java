package racingcar.view;

import racingcar.common.util.OutputMessage;

public class OutputView {

    public void outputStartMessage() {
        printlnOut(OutputMessage.START
                .getMessage());
    }

    public void outputTryNumberMessage() {
        printlnOut(OutputMessage.TRY_NUMBER
                .getMessage());
    }

    public void outputResultMessage() {
        printlnOut(OutputMessage.RESULT
                .getMessage());
    }

    public void outputFinishMessage() {
        printOut(OutputMessage.FINISH
                .getMessage());
    }

    public void outputRacingResult(String carName, Integer location) {
        printlnOut(carName + " : " + "-".repeat(location));
    }

    public void outputCustomMessage(String message) {
        printlnOut(message);
    }

    public void outputWinners(String winners) {
        printlnOut(winners);
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }

    private void printOut(String message) {
        System.out.print(message);
    }
}
