package racingcar.view;

public class OutputView {

    private static final String CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_INPUT_MSG = "시도할 회수는 몇회인가요?";
    private static final String LINE = "\n";
    private static final String RESULT_MSG = LINE + "실행 결과";

    public void printRequestCarNameMessage() {
        System.out.println(CAR_NAME_INPUT_MSG);
    }

    public void printRequestCountMessage() {
        System.out.println(TRIAL_COUNT_INPUT_MSG);
    }
}
