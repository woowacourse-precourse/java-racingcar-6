package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberPicker implements NumberPicker{
    private static final int RACING_NUMBER_START = 0;
    private static final int RACING_NUMBER_END = 9;

    @Override
    public int pickNumber() {
        return  Randoms.pickNumberInRange(RACING_NUMBER_START,RACING_NUMBER_END);
    }
}
