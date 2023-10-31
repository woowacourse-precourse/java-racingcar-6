package racingcar.model;

public class AttemptNum {
    public void isValid(String attemptsNum) {
        if (!attemptsNum.matches("^[0-9]+") || attemptsNum.equals("0")) {
            throw new IllegalArgumentException();
        }
    }
}