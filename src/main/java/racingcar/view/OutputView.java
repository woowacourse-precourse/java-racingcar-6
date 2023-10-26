package racingcar.view;

public class OutputView {

    private static final String LINE = "\n";
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + LINE;
    private static final String REQUEST_RACE_COUNT = "시도할 회수는 몇회인가요?" + LINE;
    private static final String EXECUTION_RESULT = "실행 결과" + LINE;
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void displayRequestCarName() {
        System.out.print(REQUEST_CAR_NAME);
    }

    public void displayRequestRaceCount() {
        System.out.print(REQUEST_RACE_COUNT);
    }

    public void displayExecutionResult(String message) {
        System.out.print(EXECUTION_RESULT + message);
    }

    public void displayFinalWinners(String message) {
        System.out.println(FINAL_WINNER + message);
    }
}
