package racingcar.model;

public class roundNumberValidator {
    public static int roundNumberException(String roundNumberString){
        isRoundNumberNull(roundNumberString);
        isRoundNumberNumeric(roundNumberString);
        try {
            int roundNumber = Integer.parseInt(roundNumberString);
            return roundNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다");
        }
    }
    public static void isRoundNumberNull(String roundNumberString) {
        if (roundNumberString.isEmpty()) throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
    }
    public static void isRoundNumberNumeric(String roundNumverString){
        if(!roundNumverString.matches("[0-9]+")) throw new IllegalArgumentException("양의 정수를 입력해주세요");
        if(roundNumverString.equals("0")) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }
}
