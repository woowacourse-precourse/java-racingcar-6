package racingcar.assist;

import racingcar.system.SystemConstant;

public class NumberComparator {

    private RandomNumberGenerator randomNumberGenerator;

    public NumberComparator(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public boolean isNumberOverWinNumber(){
        int carTrialRandomNumber = randomNumberGenerator.generateRandomIntNumberInRange();
        return carTrialRandomNumber >= SystemConstant.GO_FORWARD_REQUIRE_AT_LEAST;
    }
}
