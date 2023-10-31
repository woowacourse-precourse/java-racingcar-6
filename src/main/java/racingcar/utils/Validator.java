package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void validateUserInputIsCorrectFormat(String userInput){
        List<String> toValidateRacerNameList = Util.parseStringToListSplitComma(userInput);
        for (String validateRacerName : toValidateRacerNameList){
            validateRacerNameIsContainSpecificSymbol(validateRacerName);
            validateRacerNameWithinMaxLength(validateRacerName);
        }
        validateRacerNameIsNotDuplicated(toValidateRacerNameList);
    }
    private void validateRacerNameIsContainSpecificSymbol(String racerName){
        for (char element : racerName.toCharArray()){
            if (Character.isLetterOrDigit(element)){
                continue;
            }
            throw new IllegalArgumentException("입력된 값이 형식에 맞지 않습니다!");
        }
    }
    private void validateRacerNameWithinMaxLength(String racerName){
        if (racerName.length()>5){
            throw new IllegalArgumentException("이름이 너무 깁니다!");
        }
    }
    private void validateRacerNameIsNotDuplicated(List<String> racerNameList){
        Set<String> stringSet = new HashSet<>();
        stringSet.addAll(racerNameList);
        if (racerNameList.size() == stringSet.size())
            return;
        throw new IllegalArgumentException("중복된 이름이 있습니다!");
    }
    public void validateUserInputIsCorrectCount(String userInput){
        validateUserInputIsInteger(userInput);
        Integer count = Integer.parseInt(userInput);
        validateIntegerIsPositiveInteger(count);
    }
    private void validateUserInputIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("양의 정수를 입력해주세요!");
        }
    }
    private void validateIntegerIsPositiveInteger(Integer count){
        if (count<=0){
            throw new IllegalArgumentException("양의 정수를 입력해주세요!");
        }
    }
}