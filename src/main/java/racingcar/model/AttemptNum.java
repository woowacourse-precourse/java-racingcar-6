package racingcar.model;

public class AttemptNum {
    public void isValid(String attemptsNum) {
        if (!attemptsNum.matches("^[1-9]\\d") || attemptsNum.equals("0")){
            throw new IllegalArgumentException();
        }
    }
}
