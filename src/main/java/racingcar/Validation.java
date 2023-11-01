package racingcar;

public class Validation {
    public static void validateNameLengthNotOver(String name, int limit) {
        if (name.length() > limit) {
            throw new IllegalArgumentException("이름의 길이는 " + limit + "글자를 넘으면 안됩니다.");
        }
    }
    public static void validateNotEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름이 있습니다.");
        }
    }

    public static void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }

    public static void validateNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력 값은 양수여야 합니다.");
        }
    }
}
