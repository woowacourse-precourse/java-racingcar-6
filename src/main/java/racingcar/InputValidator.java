package racingcar;

import java.util.List;

public class InputValidator {
    public void checkNameLength(List<String> cars){
        for(int i = 0; i < cars.size(); i++){
            String car = cars.get(i);
            if(car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    //입력값에 띄어쓰기 검사
    public void checkInputForSpaces(String inputValue){
        if(inputValue.contains(" ")) throw new IllegalArgumentException("입력값에 띄어쓰기가 포함되어 있습니다.");
    }

    public void checkInputEmpty(String inputValue){
        if(inputValue.isEmpty()) throw new IllegalArgumentException("입력값이 비어있습니다.");
    }
}
