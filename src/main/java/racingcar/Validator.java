package racingcar;

public class Validator {
    public static boolean validateCarName(String carName) {
        if(carName.length() <= 5) return true;
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }
    public static boolean validateNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
