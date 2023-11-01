package racingcar.util;

public class Validator {

    public static void checkLengthvalidator(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("글자 수를 초과하셨습니다.");
        }
    }
    public static void checkNumberValidation(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 다시 입력해주세요");
        }
    }
}
