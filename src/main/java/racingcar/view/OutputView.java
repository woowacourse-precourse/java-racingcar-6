package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String GAME_WINNER = "최종 우승자 : ";

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printRacingCarStatus(List<String> carStatus) {
        for (String status : carStatus) {
            System.out.println(status);
        }
        System.out.println();
    }

    public void printGameWinner(String winners) {
        System.out.println(GAME_WINNER + winners);
    }

}