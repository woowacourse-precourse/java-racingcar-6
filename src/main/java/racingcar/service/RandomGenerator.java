package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.util.FinalNumber.*;


public class RandomGenerator {
    public int generateRandom() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
    }

    public boolean isForward() {
        return generateRandom() >= MIN_FORWARD_NUMBER;
    }
}
