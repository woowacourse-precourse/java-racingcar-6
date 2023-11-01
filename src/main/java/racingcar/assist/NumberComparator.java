package racingcar.assist;

import static racingcar.system.SystemConstant.WIN_NUMBER_AT_LEAST;

public class NumberComparator {

    private RandomNumberGenerator randomNumberGenerator;

    public NumberComparator(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public boolean isNumberOverWinNumber(){
        int carTrialRandomNumber = randomNumberGenerator.generateRandomIntNumberInRange();
        return carTrialRandomNumber >= WIN_NUMBER_AT_LEAST;
    }
}
