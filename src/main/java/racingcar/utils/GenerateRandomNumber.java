package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
