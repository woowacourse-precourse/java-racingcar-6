package racingcar;

import java.util.Map;

public class InputValidator {
    private final static int CAR_NAME_LENGTH = 5;

    public final static String DUPLICATED_NAME = "중복된 자동차 이름이 존재합니다.";
    private final static String INVALID_LENGTH_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";
    private final static String NULL_MESSAGE = "자동차 이름이 입력되지 않았습니다.";
    private final static String NOT_INTEGER_MESSAGE = "0 이상의 숫자를 입력해주세요.";

    public void carNameValidator(Map<String, Integer> cars){
        checkCarNameLength(cars);
        checkCarNameNull(cars);
    }

    public void gameCountValidator(String input){
        checkPositive(checkInteger(input));
    }

    private void checkCarNameLength(Map<String, Integer> cars){
        if(cars.keySet().stream().anyMatch(key -> key.length() > CAR_NAME_LENGTH))
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
    }

    private void checkCarNameNull(Map<String, Integer> cars){
        if(cars.keySet().stream().anyMatch(key -> key.trim().isEmpty()))
            throw new IllegalArgumentException(NULL_MESSAGE);
    }

    private int checkInteger(String count){
        try{
            return Integer.parseInt(count);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    private void checkPositive(int count){
        if(count<1) throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
    }

}
