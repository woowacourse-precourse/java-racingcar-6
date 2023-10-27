package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public static final int RANDOM_NUMBER_FROM = 0;
    public static final int RANDOM_NUMBER_TO = 9;
    public static final int MOVABLE_POINT = 4;
    private final Integer number;

    private RandomNumber(Integer number) {
        this.number = number;
    }

    private static RandomNumber createRandomNumber() {
        return new RandomNumber(getRandomNumber());
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_FROM, RANDOM_NUMBER_TO);
    }

    public boolean isMovable() {
        return number >= MOVABLE_POINT;
    }

}
