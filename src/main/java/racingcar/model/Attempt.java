package racingcar.model;

public class Attempt {
    public void isValid(String attemptsNum) {
        if (!attemptsNum.matches("^[1-9]+$")){
            throw new IllegalArgumentException();
        }
    }
}
