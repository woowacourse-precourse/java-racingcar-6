package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class ForwardCar {
    public int forwardNum = 0;
    void forward(){
        if(Randoms.pickNumberInRange(0,9) > 3){
            forwardNum++;
        }
    }
}
