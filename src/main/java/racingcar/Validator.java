package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public void validateUserInputIsCorrectFormat(String userInput){
        List<String> toValidateRacerNameList = Arrays.asList(userInput.split(","));
        for (String validateRacerName : toValidateRacerNameList){
            validateRacerNameIsContainSpecificSymbol(validateRacerName);
        }
    }
    private void validateRacerNameIsContainSpecificSymbol(String racerName){
        for (char element : racerName.toCharArray()){
            if (Character.isLetterOrDigit(element)){
                continue;
            }
            throw new IllegalArgumentException("입력된 값이 형식에 맞지 않습니다!");
        }
    }
}