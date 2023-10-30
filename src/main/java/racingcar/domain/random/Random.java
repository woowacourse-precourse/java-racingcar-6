package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    private int randomNumber;

    public Random() {
        randomNumber = 0;
    }

    public void generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0,9);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
