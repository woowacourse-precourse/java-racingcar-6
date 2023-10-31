package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class racingCar {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_POINT = 4;
    public String racingCarName;
    private int forwardCount;
    private int randomNumber;

    public racingCar(String racingCarName) {
        this.racingCarName = racingCarName;
        this.forwardCount = 0;
    }

    public void randomRace() {
        randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (randomNumber >= FORWARD_POINT) forwardCount++;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }
}
