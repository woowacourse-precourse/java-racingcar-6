package racingcar.util;

import static racingcar.Config.FORWARD_CONDITION;

public class Util {



    // 8. 값이 4이상인지 확인하는 기능
    public static boolean isSameOrBiggerThanFour(int number){
        if(number >= FORWARD_CONDITION){
            return true;
        } else {
            return false;
        }
    }
}
