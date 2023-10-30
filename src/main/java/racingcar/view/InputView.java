package racingcar.view;

import racingcar.domain.Input;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarName() {
        System.out.println(START_MESSAGE);
        return Input.inputString();
    }

    public static String inputNumberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
        return Input.inputString();
    }
}
