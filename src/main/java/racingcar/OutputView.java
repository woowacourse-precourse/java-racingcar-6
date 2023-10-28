package racingcar;

public class OutputView {
    private static final String REQUEST_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printRequestInputCarName() {
        System.out.println(REQUEST_INPUT_CAR_NAME_MESSAGE);
    }

    public void printRequestInputTryNumber() {
        System.out.println(REQUEST_INPUT_TRY_NUMBER_MESSAGE);
    }

    public void printPlayResult() {
        space();
        System.out.println(RESULT_MESSAGE);
    }

    public void space() {
        System.out.println();
    }
}
