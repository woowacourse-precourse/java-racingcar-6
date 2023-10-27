package racingcar.view;

public class OutputView {

    private static final String LINE = "\n";
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + LINE;
    private static final String REQUEST_RACE_COUNT = "시도할 회수는 몇회인가요?" + LINE;
    private static final String EXECUTION_RESULT = "실행 결과" + LINE;
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void displayRequestCarNames() {
        System.out.print(REQUEST_CAR_NAME);
    }

    public void displayRequestRaceCount() {
        System.out.print(REQUEST_RACE_COUNT);
    }

    public void displayExecutionResult() {
        System.out.print(EXECUTION_RESULT);
    }

    public void displayRacingState(String message) {
        System.out.print(message + LINE + LINE);
    }

    public void displayFinalWinners(String message) {
        System.out.print(FINAL_WINNER + message);
    }
}
