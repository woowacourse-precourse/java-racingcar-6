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


    public void outputRacingResult(String carName, Integer location) {
        printlnOut(carName + " : " + "-".repeat(location));
        printlnOut("");
    }


    private void printlnOut(String message) {
        System.out.println(message);
    }

}
