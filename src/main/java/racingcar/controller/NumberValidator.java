package racingcar.controller;

public class NumberValidator {

    public boolean isOverFour(int randomNumber) {
        return randomNumber >= 4;
    }

    public boolean isValidNumber(int randomNumber) {
        if(randomNumber >= 0 && randomNumber <= 9)
            return true;
        else
            throw new IllegalArgumentException("숫자가 아닙니다.");
    }
}
