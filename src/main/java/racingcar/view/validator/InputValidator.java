package racingcar.view.validator;

import org.junit.platform.commons.util.StringUtils;

public class InputValidator {

    protected static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }
}
