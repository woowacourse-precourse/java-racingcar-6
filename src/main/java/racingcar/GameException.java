package racingcar;

import java.util.ArrayList;

public class GameException {
    public void NameCount(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    public void NameNull(ArrayList<String> allCar){
        if (allCar.isEmpty()){
            throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력해주세요.");
        }
    }
}
