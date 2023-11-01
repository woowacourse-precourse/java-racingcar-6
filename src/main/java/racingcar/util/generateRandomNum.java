package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class generateRandomNum {
    public static int generate() {
        return Randoms.pickNumberInRange(1,9);
    }
}
