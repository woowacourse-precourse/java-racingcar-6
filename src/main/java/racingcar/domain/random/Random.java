package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private int randomNumber;

    public void generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
