package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    TypeConverter typeConverter = new TypeConverter();
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이가 5보다 큽니다.";
    private static final String NAME_SPACE_ERROR_MESSAGE = "이름에 공백이 존재합니다.";
    private static final String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 존재합니다.";
    public void validateCarNames(List<String> input){
        validateNameLength(input);
        validateNameSpace(input);
        validateNameDuplication(input);
    }
    public void validateNameLength(List<String> input){
        for(String carName : input){
            if(carName.length() > 5){
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
    public void validateNameSpace(List<String> input){
        for(String carName : input){
            if(carName.contains(" ")){
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


}
