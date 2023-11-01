package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MINIMUM_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MINIMUM_ADVANCE = 4;

    private final String name;
    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void runTrack() {
        if (getRandomNumber() >= MINIMUM_ADVANCE) {
            currentPosition++;
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE, MAX_RANGE);
    }

}
