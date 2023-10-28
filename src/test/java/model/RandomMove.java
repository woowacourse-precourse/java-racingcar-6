package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RandomMove {
    boolean isMove(){
        if(Randoms.pickNumberInRange(0,9)>=4) {
            return true;
        }
        return false;
    }

    boolean isMove1(Map<String, Integer> cars){
        if(Randoms.pickNumberInRange(0,9)>=4) {

        }
        return false;
    }
}
