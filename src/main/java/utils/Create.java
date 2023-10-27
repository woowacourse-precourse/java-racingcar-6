package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Create {
    public static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
