package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {
    public static int getRandomNumber() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random;
    }
}
