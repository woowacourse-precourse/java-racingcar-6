package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarRandoms{
    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
