package racingcar.validator;

public class InputValidator {
    public static void lessThenFiveLetters(String input){
        // TODO: 상수 교체
        if (input.length() > 5) {
            Exception.illegalArgument("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
