package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    TypeConverter typeConverter = new TypeConverter();
    private static final String NAME_ERROR_MESSAGE = "이름의 길이가 5보다 큽니다.";
    public void validateCarNames(List<String> input){
        validateNameLength(input);
        validateNameSpace(input);
        validateNameDuplication(input);
    }
    public void validateNameLength(List<String> input){
        for(String carName : input){
            if(carName.length() > 5){
                throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
            }
        }
    }


}
