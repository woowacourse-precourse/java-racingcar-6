package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int RANDOM_NUMBER_FROM = 0;
    private static final int RANDOM_NUMBER_TO = 9;
    private static final int MOVABLE_POINT = 4;
    private final Integer number;

    public RandomNumber(Integer number) {
        this.number = number;
    }

    public static RandomNumber createRandomNumber() {
        return new RandomNumber(getRandomNumber());
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_FROM, RANDOM_NUMBER_TO);
    }

    public boolean isMovable() {
        return number >= MOVABLE_POINT;
    }

}
