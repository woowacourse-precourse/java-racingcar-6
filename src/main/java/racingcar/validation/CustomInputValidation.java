package racingcar.validation;

public class CustomInputValidation {

    public static void carNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하입니다.");
            }
        }
    }

    public static void numOfCars(int length) {
        if (length < 2) {
            throw new IllegalArgumentException("차는 두 대 이상 입력해야 합니다.");
        }
    }


    public static void isPositive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("양수를 입력해야 합니다.");
        }
    }

    public static int parseAndValidateInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 정수가 아닙니다: " + input);
        }
    }
}
