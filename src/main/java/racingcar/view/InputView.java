package racingcar.view;

public class InputView {
    
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printCarNameRequest() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printAttemptCountRequest() {
        System.out.println(ATTEMPT_COUNT_REQUEST_MESSAGE);
    }
}
