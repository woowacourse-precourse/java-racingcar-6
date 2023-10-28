package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public void checkNameLength(List<String> cars){
        for(String car : cars){
            if(car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
    //자동차 이름 중복 체크
    public void checkNameDuplicate(List<String> cars){
        Set<String> carsSet = new HashSet<>(cars);
        if(cars.size() != carsSet.size()) throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
    }

    //입력값에 띄어쓰기 검사
    public void checkInputForSpaces(String inputValue){
        if(inputValue.contains(" ")) throw new IllegalArgumentException("입력값에 띄어쓰기가 포함되어 있습니다.");
    }

    public void checkInputEmpty(String inputValue){
        if(inputValue.isEmpty()) throw new IllegalArgumentException("입력값이 비어있습니다.");
    }
}
