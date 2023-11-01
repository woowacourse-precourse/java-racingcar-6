package racingcar.domain;

import racingcar.exception.ForwardTryCountFormatException;

public class ForwardTryCount {

    private int count;

    public ForwardTryCount(String countString) {

        validate(countString);
        count = Integer.parseInt(countString);

    }

    private void validate(String countString) {
        checkNumeric(countString);
        checkNaturalNumber(countString);
    }

    private void checkNaturalNumber(String countString) {
        int count = Integer.parseInt(countString);
        if (count <= 0) {
            throw new ForwardTryCountFormatException();
        }
    }

    private void checkNumeric(String countString) {
        boolean isNumeric = countString.chars()
                                       .allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new ForwardTryCountFormatException();
        }
    }

    public void subCount() {
        count--;
    }

    public boolean hasZeroCount() {
        return this.count == 0;
    }

}
