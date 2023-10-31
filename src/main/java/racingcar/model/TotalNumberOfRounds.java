package racingcar.model;

import racingcar.exception.round.totalNumberOfRounds.NonPositiveIntegerException;

public class TotalNumberOfRounds {
    private final int total;

    public TotalNumberOfRounds(int total) {
        validateTotal(total);
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    private void validateTotal(int total) {
        if (total < 0) {
            throw new NonPositiveIntegerException();
        }
    }
}
