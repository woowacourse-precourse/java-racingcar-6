package racingcar.assist;

import racingcar.system.SystemConstant;

public class NumberComparator {

    private RandomNumberGenerator randomNumberGenerator;

    NumberComparator(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    private boolean isNumberOverWinNumber(){
        int carTrialRandomNumber = randomNumberGenerator.generateRandomIntNumberInRange();
        return carTrialRandomNumber > SystemConstant.GO_FORWARD_REQUIRE_AT_LEAST;
    }
}
