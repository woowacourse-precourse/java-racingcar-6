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
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해주세요");
        }
    }

    private void checkCarNameDuplicated(String carName){
        if(!existCarNames.add(carName)){
            throw new IllegalArgumentException("자동차의 이름이 중복됩니다.");
        }
    }

    private void checkCarNameLength(String carName){
        if (carName.length() > 4){
            maxLengthException();
        }
        if (carName.length() < 1){
            minLengthException();
        }
    }

    private void maxLengthException(){
        throw new IllegalArgumentException("자동차 이름은 5글자 미만여야 합니다.");
    }

    private void minLengthException(){
        throw new IllegalArgumentException("자동차 이름은 1글자 이상이야 합니다.");
    }

    private void invalidSpace(String carName){
        if (carName.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 포함되어선 안됩니다.");
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
            throw new IllegalArgumentException("숫자를 옳바르게 입력해주세요");
        }
    }
}
