package repository;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
