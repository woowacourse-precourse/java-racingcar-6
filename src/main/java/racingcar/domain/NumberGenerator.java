package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    protected NumberGenerator() {

    }

    public static Integer[] createRandomNumbers(int carsLen) {
        Integer[] result = new Integer[carsLen];
        for (int i = 0; i < carsLen; i++) {
            result[i] = Randoms.pickNumberInRange(0, 9);
        }
        return result;
    }
}
