package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.message.ProcessMessage;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(ProcessMessage.INPUT_NAME);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(ProcessMessage.INPUT_ATTEMPT_COUNT);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printProcessResultTitle() {
        printNewLine();
        System.out.println(ProcessMessage.PROCESS_RESULT);
    }

    public void printWinnerName(Winners winners) {
        printWinnerTitle();
        System.out.print(winners.toString());
    }

    private void printWinnerTitle() {
        System.out.print(ProcessMessage.WINNER_TITLE);
    }

    public void printMoveRecords(Cars cars) {
        System.out.println(cars.getMoveRecord());
    }
}
