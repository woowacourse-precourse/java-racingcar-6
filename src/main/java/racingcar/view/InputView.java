package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return getInput();
    }

    public static int inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(getInput());
    }

    private static String getInput() {
        return Console.readLine();
    }

}
