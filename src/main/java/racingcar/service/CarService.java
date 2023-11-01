package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    public static boolean checkCarMovement(){
        int randomNum = Randoms.pickNumberInRange(0,9);

        if(randomNum >= 4){
            return true;
        }
        return false;
    }
}
