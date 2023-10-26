package racingcar.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DriveStop {

    public boolean isDrive(){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if(randomNum <= 3){
            return false;
        } else {
            return true;
        }
    }

}
