package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

    static int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    static Boolean decideMovement(int randomNum){
        if(randomNum >= 4) return true;
        else return false;
    }

}
