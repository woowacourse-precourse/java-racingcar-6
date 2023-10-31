package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String ATTEMPTS_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public static String inputAttempts() {
        System.out.println(ATTEMPTS_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
