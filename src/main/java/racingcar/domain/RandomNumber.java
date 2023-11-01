package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RandomNumber {
    public String createRandomNumber(String carName){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        String moveCar = "";
        if (randomNum >= 4){
            moveCar += "-";
        } else if(randomNum < 4){
            moveCar += "";
        }
        return moveCar;
    }
}
