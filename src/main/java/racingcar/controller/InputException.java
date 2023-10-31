package racingcar.controller;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static racingcar.utility.Constants.IMPROPER_COMMA_POSITION_PATTERN;
import static racingcar.utility.Constants.VAILD_RACING_COUNT_PATTERN;
import static racingcar.utility.Constants.NAME_LENGTH_LIMIT;

public class InputException {

    public InputException(){}

    public void carsNameException(String carsName){
        if(isCarsNameEmpty(carsName)){ //문자열에 비었을 때 (엔터 입력시)
            throw new IllegalArgumentException();
        }

        if(isCommaAtImproperPosition(carsName)){
            throw new IllegalArgumentException();
        }

        if(isCarNameBiggerThanFive(carsName)){
            throw new IllegalArgumentException();
        }

        if(isCarNameDuplicate(carsName)){
            throw new IllegalArgumentException();
        }
    }

    public void isVaildRacingCount(int racingCount){
        if(!isPositiveInteger(racingCount)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isCommaAtImproperPosition(String carsName){
        return(Pattern.matches(IMPROPER_COMMA_POSITION_PATTERN,carsName));
    }

    private boolean isCarsNameEmpty(String carsName){
        if(carsName.length() == 0){
            return true;
        }
        return false;
    }
    
    private String[] splitCarsName(String carsName){
        String[] carsNameArray = carsName.split(",");
        return carsNameArray;
    }
    
    private boolean isCarNameBiggerThanFive(String carsName){
        String[] carsNameArray = splitCarsName(carsName);

        for (String carName : carsNameArray) {
            if(carName.length() > NAME_LENGTH_LIMIT){
                return true;
            }
        }

        return false;
    }

    private boolean isCarNameDuplicate(String carsName){
        String[] carsNameArray = splitCarsName(carsName);

        return Arrays.stream(carsNameArray)
                .distinct() //중복제거
                .toArray()
                .length != carsNameArray.length; //기존 배열과 길이 다르면 true 반환
    }

    private boolean isPositiveInteger(int racingCount){
        return(Pattern.matches(VAILD_RACING_COUNT_PATTERN, Integer.toString(racingCount)));
    }
}
