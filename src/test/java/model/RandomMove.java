package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RandomMove {
    boolean isMove(){
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }
}
