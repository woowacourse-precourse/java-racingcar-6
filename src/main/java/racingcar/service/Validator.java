package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    TypeConverter typeConverter = new TypeConverter();
    public void validateCarNames(List<String> input){
        validateLength(input);
        validateSpace(input);
        validateDuplication(input);
    }


}
