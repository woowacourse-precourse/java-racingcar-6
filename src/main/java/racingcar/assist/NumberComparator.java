package racingcar.assist;

public class NumberComparator {

    private RandomNumberGenerator randomNumberGenerator;

    public NumberComparator(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public boolean isNumberOverWinNumber(int winNumber){
        int carTrialRandomNumber = randomNumberGenerator.generateRandomIntNumberInRange();
        return carTrialRandomNumber >= winNumber;
    }
}
