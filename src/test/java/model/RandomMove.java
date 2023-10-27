package model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove {
    boolean isMove(){
        if(Randoms.pickNumberInRange(0,9)>=4) {
            return true;
        }else {
            return false;
        }
    }
}
