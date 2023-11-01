package racingcar.view;

public class View {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAttemptsMessage() {
        System.out.println(ASK_ATTEMPTS_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
