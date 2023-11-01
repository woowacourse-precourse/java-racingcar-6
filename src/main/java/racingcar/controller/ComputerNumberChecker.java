package racingcar.controller;

public class ComputerNumberChecker {
    public boolean isComputerNumberGreaterThanFour(int number) {
        if (number >= 4) {
            return true;
        } else if (number >= 0 && number < 4) {
            return false;
        } else {
            throw new IllegalArgumentException("숫자가 유효하지 않습니다.");
        }
    }
}
