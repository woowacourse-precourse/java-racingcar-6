package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    //자동차 이름 예외 체크
    public void checkCarsName(List<String> cars){
        if(checkCarsNameLength(cars)) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        else if(checkCarsNameDuplicate(cars)) throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
    }

    //자동차 이름, 시도할 횟수 예외 체크
    public void checkInputValue(String inputValue){
        if(checkInputForSpaces(inputValue)) throw new IllegalArgumentException("입력값에 띄어쓰기가 포함되어 있습니다.");
        else if(checkInputEmpty(inputValue)) throw new IllegalArgumentException("입력값이 비어있습니다.");
    }
    //시도할 횟수 예외 체크
    public void checkEttempts(String ettempts){
        if(!checkNumericOnly(ettempts)) throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
    }



    private boolean checkCarsNameLength(List<String> cars){
        boolean result = false;
        for(String car : cars) if (car.length() > 5) result = true;
        return result;
    }

    //자동차 이름 중복 체크
    private boolean checkCarsNameDuplicate(List<String> cars){
        Set<String> carsSet = new HashSet<>(cars);
        return cars.size() != carsSet.size();
    }


    //입력값에 띄어쓰기 검사
    private boolean checkInputForSpaces(String inputValue){
        return inputValue.contains(" ");
    }

    private boolean checkInputEmpty(String inputValue){
        return inputValue.isEmpty();
    }

    private boolean checkNumericOnly(String attempts){
        return attempts.matches("\\d+");
    }
}
