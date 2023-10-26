package racingcar;

public class OutputManager {
    private static final String REQUEST_CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_GAME_COUNT_INPUT = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    private static final String ONE_STEP = "-";

    public void printRequestCarNameInputMessage() {
        System.out.println(REQUEST_CAR_NAME_INPUT);
    }

    public void printRequestGameCountInputMessage() {
        System.out.println(REQUEST_GAME_COUNT_INPUT);
    }

    public void printResult() {
        System.out.println(RESULT);
        // TODO: 차 이름과 위치 출력
    }

    public void printWinner() {
        System.out.print(WINNER);
    }
}
