package racingcar.controller;

public class OutputView {

    public static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GET_ATTEMPT_MESSAGE = "시도할 횟수는 몇회인가요?";

    public void printGetCarNames() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
    }

    public void printGetAttempt() {
        System.out.println(GET_ATTEMPT_MESSAGE);
    }

}
