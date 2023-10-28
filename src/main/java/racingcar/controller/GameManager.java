package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class GameManager {
    public void checkMovePossible(Car car){
        int random = createRandomNumber();
        if(random >= 4){
            car.move();
        }
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
