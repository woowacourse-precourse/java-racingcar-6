package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarRandoms{
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
