package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public final class Utils {
    public static int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean isNumberRange(int number){
        return (number >= 0 && number <= 9);
    }
}
