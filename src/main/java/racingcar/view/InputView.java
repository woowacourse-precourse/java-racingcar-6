package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String INVALID_STRING_ERROR_MESSAGE_FORMAT = "[%s] : 공백은 입력될 수 없습니다.";
    private static final String INVALID_NUMBER_ERROR_MESSAGE_FORMAT = "[%s] : 숫자를 입력해주세요.";
    private static final String INVALID_POSITIVE_ERROR_NUMBER_MESSAGE_FORMAT = "[%s] : 자연수를 입력해주세요.";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = inputString();
        validateString(input);
        return input;
    }

    private String inputString() {
        return Console.readLine();
    }

    private void validateString(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_STRING_ERROR_MESSAGE_FORMAT.formatted(input));
        }
    }

    public int inputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        return inputPositiveNumber();
    }

    private int inputPositiveNumber() {
        String input = Console.readLine();
        validateNumber(input);
        validatePositiveNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE_FORMAT.formatted(input));
        }
    }

    private void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(INVALID_POSITIVE_ERROR_NUMBER_MESSAGE_FORMAT.formatted(input));
        }
    }
}
