package racingcar.validator;

public class CarNameValidator {


    private static final int NAME_MAX_LENGTH = 5;
    private static final char BLANK = ' ';

    public static void validate(String carName) {
        checkNameLength(carName);
        checkNameBlankStart(carName);
        checkNameBlankEnd(carName);
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static void checkNameBlankStart(String carName) {
        if (carName.charAt(0) == BLANK) {
            throw new IllegalArgumentException("이름이 공백으로 시작하면 안됩니다.");
        }
    }

    private static void checkNameBlankEnd(String carName) {
        if (carName.charAt(carName.length() - 1) == BLANK) {
            throw new IllegalArgumentException("이름이 공백으로 끝나면 안됩니다.");
        }
    }
}
