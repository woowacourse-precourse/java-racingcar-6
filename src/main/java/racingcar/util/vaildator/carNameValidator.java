package racingcar.util.vaildator;

public class carNameValidator {
    private static final int MAX_INPUT_NAME_SIZE = 5;
    private static final String INPUT_NAME_SIZE_EXCEPTION = "이름이 5자를 초과하였습니다.";
    private static final String INPUT_NAME_EXCEPTION = "이름을 입력해주세요.";

    public static void validateInputNameSize(String name) {
        if (name.length() > MAX_INPUT_NAME_SIZE) {
            throw new IllegalArgumentException(INPUT_NAME_SIZE_EXCEPTION);
        }
    }

    public static void validateInputName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NAME_EXCEPTION);
        }
    }

}
