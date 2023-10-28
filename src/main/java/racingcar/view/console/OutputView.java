package racingcar.view.console;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceProgress() {
    }

    public void println() {
        System.out.println();
    }

    public void printRaceWinners(List<String> raceWinners) {
        System.out.println(WINNERS_MESSAGE + String.join(", ", raceWinners));
    }
}
