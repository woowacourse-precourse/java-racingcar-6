package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NumericValidator;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";


    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private InputView() {
        throw new AssertionError();
    }

    public static String readCarNames() {
        return readLine(INPUT_CAR_NAMES);
    }

    public static int readNumberOfAttempts() {
        final String stringNumber = readLine(INPUT_NUMBER_OF_ATTEMPTS);
        NumericValidator.validate(stringNumber);
        return Integer.parseInt(stringNumber);
    }

    private static String readLine(final String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
