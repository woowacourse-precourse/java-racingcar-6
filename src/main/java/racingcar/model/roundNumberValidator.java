package racingcar.model;

public class roundNumberValidator {
    public static void roundNumberException(String roundNumberString){
        isRoundNumberNull(roundNumberString);
    }
    public static void isRoundNumberNull(String roundNumberString) {
        if (roundNumberString.isEmpty()) throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
    }
}
