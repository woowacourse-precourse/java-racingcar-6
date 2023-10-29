package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final int START_INCLUSION_NUMBER = 0;
    private static final int END_INCLUSION_NUMBER = 9;
    private static final int NUMBER_OF_ADVANCE = 4;
    private static final int PLUS_ONE = 1;
    private static final int INITIAL_MAX_ADVANCE_COUNT_VALUE = 0;

    /* 자동차 이름을 key(String)로 가지고 전진 횟수를 value(Integer)로 가진다. */
    private final Map<String, Integer> cars;
    private int maxAdvanceCount;

    public Cars(Map<String, Integer> cars) {
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

    public Winners getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        for (String name : cars.keySet()) {
            if (isWinner(name)) {
                winnerList.add(name);
            }
        }
        return new Winners(winnerList);
    }

    public List<String> getCarNameList() {
        return new ArrayList<>(cars.keySet());
    }

    public int getCarAdvanceCount(String name) {
        return cars.get(name);
    }

    private int accumulate(int randomNumber, String name) {
        if (randomNumber == NUMBER_OF_ADVANCE) {
            cars.put(name, (cars.get(name) + PLUS_ONE));
        }
        return cars.get(name);
    }

    private boolean isWinner(String name) {
        if (cars.get(name) == maxAdvanceCount) {
            return true;
        }
        return false;
    }
}
