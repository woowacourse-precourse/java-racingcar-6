package racingcar.view;

import static racingcar.constant.Constant.KOREAN_COMMA_BRACKET_DELIMITER;
import static racingcar.constant.Constant.LINE;

public class OutputView {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요." +
            "(이름은 " + KOREAN_COMMA_BRACKET_DELIMITER  +" 기준으로 구분)" + LINE;
    private static final String REQUEST_RACE_COUNT = "시도할 횟수는 몇회인가요?" + LINE;
    private static final String EXECUTION_RESULT = "실행 결과" + LINE;
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void displayRequestCarNames() {
        System.out.print(REQUEST_CAR_NAME);
    }

    public void displayRequestRaceCount() {
        System.out.print(REQUEST_RACE_COUNT);
    }

    public void displayExecutionResult() {
        System.out.print(LINE + EXECUTION_RESULT);
    }

    public void displayRacingState(String message) {
        System.out.print(message + LINE + LINE);
    }

    public void displayFinalWinners(String message) {
        System.out.print(FINAL_WINNER + message);
    }
}
