package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputController {
    private final Parser parser = new Parser();
    public void checkCarNames(String input){
        checkEmpty(input);
        List<String> carNameList = parser.parseCar(input);
        checkCarNameDuplicated(carNameList);
        checkOneByOne(carNameList);
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해주세요");
        }
    }

    private void checkCarNameDuplicated(List<String> carNameList){
        for (int i = 0; i < carNameList.size(); i++){
            for (int j = 0; j < carNameList.size(); j++){
                if (carNameList.get(i).equals(carNameList.get(j))){
                    throw new IllegalArgumentException("자동차의 이름이 중복됩니다.");
                }
            }
        }
    }

    private void checkCarNameLength(String carName){
        if (carName.length() > 5){
            maxLengthException();
        }
        if (carName.length() < 1){
            minLengthException();
        }
    }

    private void maxLengthException(){
        throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
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
}
