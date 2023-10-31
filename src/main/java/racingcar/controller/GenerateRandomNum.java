package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNum {
    public static boolean pickNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        int MOVE_FORWARD = 4;
        if(randomNum>=MOVE_FORWARD){
            return true;
        }
        return false;
    }
}
