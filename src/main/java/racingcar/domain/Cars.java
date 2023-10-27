package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Cars {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int START_INCLUSION_NUMBER = 0;
    private static final int END_INCLUSION_NUMBER = 9;
    private static final int NUMBER_OF_ADVANCE = 4;
    private static final int INITIAL_COUNT_VALUE = 0;
    private static final int PLUS_ONE = 1;
    private static final int INITIAL_MAX_ADVANCE_COUNT_VALUE = 0;
    private static final String CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE = "자동차 이름의 길이가 5를 초과했습니다.";

    /* 자동차 이름을 key(String)로 가지고 전진 횟수를 value(Integer)로 가진다. */
    private final Map<String, Integer> cars;
    private int maxAdvanceCount;

    public Cars(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            verifyCarNameLength(name);
        }
        this.cars = cars;
        this.maxAdvanceCount = INITIAL_MAX_ADVANCE_COUNT_VALUE;
    }

    public void accumulateNumberOfAdvance() {
        for (String name : cars.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSION_NUMBER, END_INCLUSION_NUMBER);
            int advanceCount = accumulate(randomNumber, name);
            maxAdvanceCount = Math.max(advanceCount, maxAdvanceCount);
        }
    }

    private void verifyCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE);
        }
    }

    private int accumulate(int randomNumber, String name) {
        if (randomNumber == NUMBER_OF_ADVANCE) {
            return cars.put(name, (cars.getOrDefault(name, INITIAL_COUNT_VALUE) + PLUS_ONE));
        }
        return cars.get(name);
    }
}
