package racingcar;

import java.util.ArrayList;

public class GameException {
    public String NameCount(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
        return carName;
    }

    public void NameNull(ArrayList<String> allCar){
        if (allCar.isEmpty() || allCar.get(0) == ""){
            throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력해주세요.");
        }
        if (allCar.size() == 1){
            throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력해주세요.");
        }
    }

    public void ZeroRound(int round){
        if(round == 0){
            throw new IllegalArgumentException("1회 이상의 라운드를 입력해주세요.");
        }
    }
}
