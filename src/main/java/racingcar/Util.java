package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

    int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    Boolean decideMovement(int randomNum){
        if(randomNum >= 4) return true;
        else return false;
    }

}
