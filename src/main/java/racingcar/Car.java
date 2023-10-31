package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Car {
    public boolean run(){
        int dice = Randoms.pickNumberInRange(0, 9);

        if(dice >= 4){
            return true;
        }

        return false;
    }
}
