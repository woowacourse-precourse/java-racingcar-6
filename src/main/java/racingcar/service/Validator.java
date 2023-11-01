package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private TypeConverter typeConverter = new TypeConverter();
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이가 5보다 큽니다.";
    private static final String NAME_SPACE_ERROR_MESSAGE = "이름에 공백이 존재합니다.";
    private static final String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 존재합니다.";
    private static final String TRIAL_NUMBER_ZERO_ERROR_MESSAGE = "입력값은 0보다 커야 합니다.";
    private static final String TRIAL_NUMBER_NON_INT_ERROR_MESSAGE = "반복 횟수는 정수 혹은 양수만 가능합니다.";
    private static final int LENGTH_CONDITION = 5;
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    public void validateCarNames(List<String> input){
        validateNameLength(input);
        validateNameSpace(input);
        validateNameDuplication(input);
    }
    public void validateNameLength(List<String> input){
        for(String carName : input){
            if(carName.length() > LENGTH_CONDITION){
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
    public void validateNameSpace(List<String> input){
        for(String carName : input){
            if(carName.contains(SPACE)){
                throw new IllegalArgumentException(NAME_SPACE_ERROR_MESSAGE);
            }
        }
    }
    public void validateNameDuplication(List<String> input){
        Set<String> set = new HashSet<>();
        for(String carName : input){
            set.add(carName);
        }
        if(set.size() != input.size()){
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
    public void validateTrialNumber(String input){
        validateNonIntTrialNumber(input);
        validateZeroTrialNumber(input);
    }
    public void validateZeroTrialNumber(String input){
        int trialNum = typeConverter.stringToInt(input);
        if(trialNum == ZERO){
            throw new IllegalArgumentException(TRIAL_NUMBER_ZERO_ERROR_MESSAGE);
        }
    }
    public void validateNonIntTrialNumber(String input){
        for(int i = ZERO ; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(TRIAL_NUMBER_NON_INT_ERROR_MESSAGE);
            }
        }
    }



}
