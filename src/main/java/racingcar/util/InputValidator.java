package racingcar.util;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int CAR_NAME_LENGTH = 5;
    private static final int GAME_MIN_PARTICIPANT = 2;
    private static final int TRY_COUNT_ZERO = 0;
    private static final String COMMA = ",";
    private static final String REGEX = "[a-zA-Z]+";
    private static final String ERROR_CODE_IS_NOT_INTERGER = "정수형 숫자를 입력해주세요.";
    private static final String ERROR_CODE_TRY_IS_ZERO = "1회 이상의 시도 횟수를 입력해주세요.";
    private static final String ERROR_CODE_CAR_NAME_LENGTH = "5자 이내의 자동차 이름을 입력해주세요.";
    private static final String ERROR_CODE_CAR_NAME_IS_NOT_STRING = "영어로 이루어진 자동차 이름을 입력해주세요";
    private static final String ERROR_CODE_CAR_NAME_DUPLICATE = "중복된 자동차 이름이 존재합니다.";
    private static final String ERROR_CODE_ONE_PARTICIPANT = "2개 이상의 자동차 이름을 입력해주세요.";
    private static final String ERROR_CODE_NO_COMMA = "이름은 쉼표 기준으로 구분해주세요.";


    public static void validateInteger(String input){
        validateTryCountIsNumber(input);
        validateTryCountZero(input);
    }

    public static void validateCarName(String input){
        validateCarNameIsString(input);
        validateCarNameLength(input);
    }

    public static void validateInputCondition(String input, String[] car){
        if(validateParticipant(car.length)){
            validateComma(input);
            validateCarNameDuplicate(car);
        }
    }


    private static void validateTryCountIsNumber(String input){
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException(ERROR_CODE_IS_NOT_INTERGER);
        }
    }

    private static void validateTryCountZero(String input){
        if(Integer.parseInt(input) == TRY_COUNT_ZERO){
            throw new IllegalArgumentException(ERROR_CODE_TRY_IS_ZERO);
        }
    }

    private static void validateCarNameLength(String input){
        if(input.length() > CAR_NAME_LENGTH){
            throw new IllegalArgumentException(ERROR_CODE_CAR_NAME_LENGTH);
        }
    }

    private static void validateCarNameIsString(String input){
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(ERROR_CODE_CAR_NAME_IS_NOT_STRING);
        }
    }

    private static void validateCarNameDuplicate(String[] car){
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(car));
        if (uniqueCarNames.size() != car.length) {
            throw new IllegalArgumentException(ERROR_CODE_CAR_NAME_DUPLICATE);
        }
    }

    private static Boolean validateParticipant(int size){
        if(size < GAME_MIN_PARTICIPANT){
            throw new IllegalArgumentException(ERROR_CODE_ONE_PARTICIPANT);
        }
        return true;
    }

    private static void validateComma(String input){
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ERROR_CODE_NO_COMMA);
        }
    }
}
