package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {


    public static int generateRandomNumber(int startNum, int endNum) {
        return Randoms.pickNumberInRange(startNum, endNum);
    }
}
