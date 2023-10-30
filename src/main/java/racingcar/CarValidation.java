package racingcar;

public class CarValidation {
    public static void hasComma(String names) throws IllegalArgumentException {
        if (!names.contains(",")) {
            throw new IllegalArgumentException("쉼표(,)가 포함되지 않은 값을 입력했습니다.");
        }
    }

    public static void isAlphabeticCharacter(String name) throws IllegalArgumentException {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i))) {
                throw new IllegalArgumentException("문자 이외의 값을 포함하는 이름을 입력했습니다.");
            }
        }
    }

    public static void isFiveCharactersOrLess(String name) throws IllegalArgumentException {
        if (name.length() > Constants.NAME_NUMBER_MAX) {
            throw new IllegalArgumentException("5자를 초과하는 이름을 입력했습니다.");
        }
    }
}
