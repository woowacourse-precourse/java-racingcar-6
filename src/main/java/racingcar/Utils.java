package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    public static int generateNumber(int min, int max){
        return Randoms.pickNumberInRange(min, max);
    }
}
