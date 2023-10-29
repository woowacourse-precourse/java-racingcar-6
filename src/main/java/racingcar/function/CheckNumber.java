package racingcar.function;

public class CheckNumber {
    public static int validate(String inputNumber) {
        validateOnlyDigits(inputNumber);
        return validatePositiveNumber(inputNumber);
    }

    private static void validateOnlyDigits(String inputNumber) {
        for (char character : inputNumber.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException("숫자로 입력 하세요.");
//                throw new IllegalArgumentException("input Number!!!");
            }
        }
    }
    private static int validatePositiveNumber(String inputNumber){
        int number = Integer.parseInt(inputNumber);
        if (number <= 0) {
            throw new IllegalArgumentException("0 이상의 값을 입력하세요");
//            throw new IllegalArgumentException("more than 1!!!!!");
        }
        return number;
    }
}
