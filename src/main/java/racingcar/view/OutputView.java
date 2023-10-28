package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TIMES = "시도할 회수는 몇회인가요?";
    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_WINNER = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    public void inputNames() {
        System.out.println(INPUT_NAME);
    }

    public void inputTimes() {
        System.out.println(INPUT_TIMES);
    }

    public void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public void printPlayerStatus(final String status) {
        System.out.println(status);
    }
    public void printWinner(final ArrayList<String> players) {
        System.out.println();
        System.out.println(PRINT_WINNER + String.join(DELIMITER, players));
    }
}
