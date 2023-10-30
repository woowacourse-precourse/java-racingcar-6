package racingcar.domain2;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    CarGame carGame = new CarGame();

    public void setUserRandomValue(List<String> cars){ //Distance 점수 업데이트
        for(String car : cars){
            if(makeRandomNumber()>=4){
                carGame.move(car);
            }
        }
    }

    private int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
