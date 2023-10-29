package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int minRange = 0;
    public static int maxRange = 9;

    public int getRandomNumberResult() {
        return Randoms.pickNumberInRange(minRange, maxRange);
    }
}
