package racingcar.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    public static void validateSeparator(String input) {
        if (input.matches(".*[^,\\s^a-zA-Z0-9^[가-힣]*$].*")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
        }
    }

    public static void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5글자로 입력해야 합니다.");
        }
    }

    public static void validateCarNameIsBlank(String carName) {
        if (carName.equals(" ") || carName.equals("")) {
            throw new IllegalArgumentException("자동차 이름을 공백으로 입력해선 안됩니다.");
        }
    }

    public static void validateIsStartBlank(String carName) {
        if (carName.matches("^\\s.*")) {
            throw new IllegalArgumentException("첫 글자를 공백으로 사용할 수 없습니다.");
        }
    }

    public static void validateIsEndBlank(String carName) {
        if (carName.matches(".*\\s$")) {
            throw new IllegalArgumentException("마지막 글자를 공백으로 사용할 수 없습니다.");
        }
    }

    public static void validateDuplication(int nameSetSize, int carCount) {
        if (nameSetSize != carCount) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }
}
