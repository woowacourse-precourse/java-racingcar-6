package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String NAME_INPUT_MESSAGE
        = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ATTEMPT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String ERROR_MESSAGE_NOT_INT_VALUE = "정수값만 입력하실 수 있습니다.";

    public static String nameInput() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int attemptInput() {
        System.out.println(ATTEMPT_INPUT_MESSAGE);
        String rawValue = Console.readLine();
        return parseInt(rawValue);
    }

    private static int parseInt(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT_VALUE);
        }
    }
}
