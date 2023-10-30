package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public record InputView() {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INVALID_STRING_ERROR_MESSAGE_FORMAT = "[%s] : 공백은 입력될 수 없습니다.";

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
}
