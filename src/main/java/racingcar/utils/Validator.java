package racingcar.utils;

public class Validator {
    public void validateTrial(int trial) {
        if(trial <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
