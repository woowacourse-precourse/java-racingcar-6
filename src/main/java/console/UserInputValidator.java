package console;

import org.junit.platform.commons.util.StringUtils;

public class UserInputValidator {
    private static final int CAR_NAME_LIMIT = 5;
    private static final String INVALID_NAME_LENGTH = "이름은 5자 이하만 가능하다.";
    private static final String MUST_NOT_BLANK = "공백 입력은 불가능하다.";

    private UserInputValidator() {
        throw new IllegalArgumentException();
    }

    public static void validate(String userInput){
        validateNotBlank(userInput);
        validateLength(userInput);
    }
    private static void validateNotBlank(String userInput){
        if (StringUtils.isBlank(userInput)) {
            throw new IllegalArgumentException(MUST_NOT_BLANK);
        }
    }
    private static void validateLength(String userInput) {
        if (userInput.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
