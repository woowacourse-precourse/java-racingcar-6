package racingcar.function;

public class NameChecker {
    private static final String ERROR_NULL_OR_EMPTY = "자동차 이름을 입력해 주세요.";
    private static final String ERROR_LENGTH = "이름을 4글자 이내로 입력해 주세요: ";
    private static final String ERROR_INVALID_CHARACTERS = "영어로 입력해 주세요: ";

    public static void validate(String inputNames) {
        nameIsNotNull(inputNames);
        correctNameCheck(inputNames);
    }

    private static void nameIsNotNull(String inputNames) {
        if (inputNames == null || inputNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
        }
    }

    private static void correctNameCheck(String inputNames) {
        String[] names = inputNames.split(",");
        for (String name : names) {
            lengthCheck(name);
            nameCharacterCheck(name);
        }
    }

    private static void lengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_LENGTH + name);
        }
    }

    private static void nameCharacterCheck(String name) {
        if (!name.matches("[a-z]+")) {
            throw new IllegalArgumentException(ERROR_INVALID_CHARACTERS + name);
        }
    }
}