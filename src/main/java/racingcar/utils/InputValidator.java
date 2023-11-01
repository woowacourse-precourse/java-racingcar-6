package racingcar.utils;

import java.util.List;

public class InputValidator {
    // 이동 횟수 관련 상수
    private static final int MIN_VALUE = 1;
    // 문자열 길이 관련 상수
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public Boolean validateNameOfLength(String name){
        Boolean isMinLengthValid = this.isMinLengthValid(name);
        Boolean isMaxLengthValid = this.isMaxLengthValid(name);
        return (isMinLengthValid && isMaxLengthValid);
    }

    public Boolean isNumericValid(String moveCount){
        try{
            Integer.parseInt(moveCount);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    // 유효성 검사: 이동 횟수가 1이상인지
    public Boolean isMinValueValid(Integer moveCount){
        return moveCount >= MIN_VALUE;
    }

    // 경주에 참여하는 자동차가 최소 2대 이상인지 확인하는 메서드
    public Boolean validateNumberOfCar(List<String> candidateCars){
        return candidateCars.size() >= 2;
    }
    public Boolean isNoSpaceValid(String name){
        return !name.contains(" ");
    }
    public Boolean isNotNullValid(String input){
        return !input.isEmpty();
    }

    private Boolean isMinLengthValid(String name){
        return name.length() >= MIN_LENGTH;
    }

    private Boolean isMaxLengthValid(String name){
        return name.length() <= MAX_LENGTH;
    }
}
