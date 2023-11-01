package racingcar.model;

public class roundNumberValidator {
    public static void roundNumberException(String roundNumberString){
        isRoundNumberNull(roundNumberString);
        isRoundNumberNumeric(roundNumberString);
    }
    public static void isRoundNumberNull(String roundNumberString) {
        if (roundNumberString.isEmpty()) throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
    }
    public static void isRoundNumberNumeric(String roundNumverString){
        if(!roundNumverString.matches("[0-9]+")) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }
}
