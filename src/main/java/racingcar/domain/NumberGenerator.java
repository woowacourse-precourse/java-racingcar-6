package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int getRandomNumberInRange(int startNum, int endNum) {
        return Randoms.pickNumberInRange(startNum, endNum);
    }
}
