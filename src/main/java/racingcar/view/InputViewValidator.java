package racingcar.view;

import java.util.HashSet;
import java.util.Set;

public class InputViewValidator {

    private static final InputViewValidator inputViewValidator = new InputViewValidator();

    private InputViewValidator() {};

    public static InputViewValidator getInstance(){
        return inputViewValidator;
    }

    public void validateCarNames(String carNames){

        if(isCarNameEmpty(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름이 빈 값일 수 없습니다");
        }
        if(isCarNameCorrectLength(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름은 길이가 5이하여야 합니다.");
        }
        if(isDuplicateCarName(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름은 중복될 수 없습니다");
        }
        if(isEachCarNameEmpty(carNames)){
            throw new IllegalArgumentException("[ERROR] : 각각의 차 이름은 공백일 수 없습니다.");
        }
    }

    public void validateTryNumber(String tryNumber){

        if(isTryNumberEmpty(tryNumber)){
            throw new IllegalArgumentException("[ERROR] : 시도 횟수가 공백일 수 없습니다");
        }
    }

    public boolean isTryNumberEmpty(String tryNumber) {
        return tryNumber.equals("");
    }

    public boolean isEachCarNameEmpty(String carNames) {
        String[] carNameList = carNames.split("");
        for (String carName : carNameList) {
            if(carName.equals("")){
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateCarName(String carNames) {
        String[] carNameList = carNames.split("");
        Set<String> carNameSet = new HashSet<>();

        for (String carName : carNameList) {
            if(!carNameSet.contains(carName)){
                carNameSet.add(carName);
            }
        }
        return carNameList.length != carNameSet.size();
    }

    public boolean isCarNameCorrectLength(String carNames) {
        String[] carNameList = carNames.split("");

        for (String carName : carNameList) {
            if(carName.length() > 5){
                return true;
            }
        }
        return false;
    }

    public boolean isCarNameEmpty(String carNames) {
        return carNames.equals("");
    }

}
