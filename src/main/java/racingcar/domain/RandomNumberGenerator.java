package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    RandomNumber randomNumber = new RandomNumber();

    public int createRandomNumber() {
        int randomNumberValue = Randoms.pickNumberInRange(0,9);
        return randomNumberValue;
    }

    public void setRandomNumberValueToRandomNumber() {
        randomNumber.setRandomNumber(createRandomNumber());
    }
}
