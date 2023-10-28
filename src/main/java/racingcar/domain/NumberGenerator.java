package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    protected NumberGenerator() {}
    public static Integer[] createRandomNumbers(int lenCars) {
        Integer[] result = new Integer[lenCars];
        for(int i=0; i<lenCars; i++) {
            result[i] = Randoms.pickNumberInRange(0,9);
        }
        return result;
    }
}
