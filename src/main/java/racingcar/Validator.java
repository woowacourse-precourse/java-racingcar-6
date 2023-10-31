package racingcar;

import java.util.List;

public class Validator {
    private static final int CAR_NAME_MIN = 1;
    private static final int CAR_NAME_MAX = 5;
    public void checkListCarNames(List<String> carsName) throws IllegalArgumentException{
        checkListDuplication(carsName);
        checkCarNameLength(carsName);
    }

    private void checkCarNameLength(List<String> carsName){
        for(String carName : carsName){
            if(CAR_NAME_MAX < carName.length()){
                throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MAX + " 글자 이하여야 합니다");
            }
        }
    }

    private void checkListDuplication(List<String> carsName) throws IllegalArgumentException{
        for(int i=0;i<carsName.size();i++){
            for(int j=i+1;j<carsName.size();j++){
                checkEqual(carsName.get(i),carsName.get(j));
            }
        }
    }

    private void checkEqual(String carName1, String carName2){
        if(carName1.equals(carName2)){
            throw new IllegalArgumentException("같은 이름을 가진 자동차가 있습니다.");
        }
    }

    public void checkStringCarNames(String input) throws IllegalArgumentException{
        checkEmpty(input);
        checkLastIndex(input);
    }

    private void checkEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkLastIndex(String input){
        if(input.lastIndexOf(",") == input.length() - 1){
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MIN + " 글자 이상 입력해주세요");
        }
    }

    public void checkTrial(String input) throws IllegalArgumentException{
        checkEmpty(input);
        checkChar(input);
    }

    private void checkChar(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}