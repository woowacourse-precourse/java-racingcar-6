package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputException {
    private Set<String> existCarNames = new HashSet<>();
    private final Parser parser = new Parser();

    public void checkCarNames(List<String> input){
        for (String carName : input){
            checkEmpty(carName);
            checkCarNameLength(carName);
            checkCarNameDuplicated(carName);
            invalidSpace(carName);
        }

    }

    public void checkNumberOfTry(String input){
        checkEmpty(input);
        checkChar(input);
        checkMinimum(input);
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(Constant.IS_EMPTY);
        }
    }

    private void checkCarNameDuplicated(String carName){
        if(!existCarNames.add(carName)){
            throw new IllegalArgumentException(Constant.IS_DUPLICATED);
        }
    }

    private void checkCarNameLength(String carName){
        if (carName.length() > Constant.MAX_LENGTH){
            maxLengthException();
        }
        if (carName.length() < Constant.MIN_LENGTH){
            minLengthException();
        }
    }

    private void maxLengthException(){
        throw new IllegalArgumentException(Constant.IS_MAXIMUM);
    }

    private void minLengthException(){
        throw new IllegalArgumentException(Constant.IS_MINIMUM);
    }

    private void invalidSpace(String carName){
        if (carName.contains(" ")){
            throw new IllegalArgumentException(Constant.IS_BLANK);
        }
    }

    private void checkOneByOne(List<String> carNameList){
        for (String carName : carNameList){
            checkEmpty(carName);
            checkCarNameLength(carName);
        }
    }

    private void checkChar(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(Constant.IS_CHAR);
        }
    }

    private void checkMinimum(String input){
       int number = Integer.parseInt(input);
       if (number < 1){
           throw new IllegalArgumentException(Constant.IS_POSITIVE);
       }
    }
}
