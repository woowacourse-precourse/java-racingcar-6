package racingcar;

import java.util.LinkedHashMap;

public class CarDataCheck {
    // 자동차 이름이 올바른지 확인하는 checkCarNameIsValid 메서드
    public void checkCarNameIsValid(LinkedHashMap<String, Integer> racingCarNames){
        for(String racingCarName : racingCarNames.keySet()){
            if(racingCarName.length() >= 6){ // 자동차 이름이 6 이상이면 예외 발생
                throw new IllegalArgumentException();
            }
        }
    }
}
