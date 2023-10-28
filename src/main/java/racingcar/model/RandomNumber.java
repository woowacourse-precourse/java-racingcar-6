package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private final int number;

    public RandomNumber() {
        this.number = generateRandomNumber();
    }

    private int generateRandomNumber() {
        int RANDOM_NUMBER_MIN = 0;
        int RANDOM_NUMBER_MAX = 9;
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public int getNumber() {
        return number;
    }
}
