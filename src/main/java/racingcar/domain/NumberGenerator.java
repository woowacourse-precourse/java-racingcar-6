package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static int getRandomNumberInRange(int startNum, int endNum) {
        return Randoms.pickNumberInRange(startNum, endNum);
    }
}
