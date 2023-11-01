package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static boolean isMoving(){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4){
            return true;
        }
        return false;
    }
}
