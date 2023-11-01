package racingcar.view;

import racingcar.model.CarStatus;

import java.util.List;

import static racingcar.view.PrintMessage.PRINT_FINAL_WINNER;

public class OutputView {

    private static final String DRIVE = "-";

    private OutputView() {}

    public static void println() {
        System.out.println();
    }

    public static void printMessage(PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printCarStatus(CarStatus carStatus) {
        System.out.println(carStatus.name() + " : " + DRIVE.repeat(carStatus.movedCount()));
    }

    public static void printWinner(List<String> winnerList) {
        if(winnerList.isEmpty())
            throw new IllegalArgumentException();

        String winnerResult = String.join(", ", winnerList);
        System.out.println(PRINT_FINAL_WINNER.getMessage() + winnerResult);
    }
}
