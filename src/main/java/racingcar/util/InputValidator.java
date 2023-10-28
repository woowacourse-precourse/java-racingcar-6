package racingcar.util;

public class InputValidator {
    // 이동 횟수 관련 상수
    private static final int MIN_VALUE = 1;
    // 문자열 길이 관련 상수
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public Boolean isMinLengthValid(String name){
        return name.length() >= MIN_LENGTH;
    }

    public Boolean isMaxLengthValid(String name){
        return name.length() <= MAX_LENGTH;
    }

    public Boolean isNumericValid(String moveCount){
        try{
            Integer.parseInt(moveCount);
            return true;
        }catch(Exception e){
            throw new IllegalArgumentException("Input Error: not numeric");
        }
    }
    // 유효성 검사: 이동 횟수가 1이상인지
    public Boolean isMinValueValid(Integer moveCount){
        return moveCount >= MIN_VALUE;
    }
}
