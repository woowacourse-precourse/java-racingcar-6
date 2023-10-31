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

    // 시도한 회수와 동일한 거리를 이동한 자동차가 있는지 확인하는 checkFinishedTime 메서드
    public boolean checkFinishedTime(LinkedHashMap<String, Integer> racingCarNames, int tryNumber){
        for(Integer carValue : racingCarNames.values()){
            if(carValue == tryNumber){ // 이동한 거리 == 시도한 회수 인 자동차가 있다면 return true
                return true;
            }
        }
        return false; // 모든 자동차가 시도한 회수에 못 미치는 거리를 이동했다면 return false
    }
}
