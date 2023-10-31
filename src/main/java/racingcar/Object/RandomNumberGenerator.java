package racingcar.Object;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private int randomNumber;

    public RandomNumberGenerator() {
        this.randomNumber = Randoms.pickNumberInRange(0,9);
    }

    public Boolean isGreaterThanOrEqualToThree() {
        return this.randomNumber >= 4;
    }

    public void rerollRandomNumber(){
        this.randomNumber = Randoms.pickNumberInRange(0,9);
    }
}
