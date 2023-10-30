package racingcar.model;

import racingcar.validator.model.TotalNumberOfRoundsValidator;

public class TotalNumberOfRounds {
    private final int total;

    public TotalNumberOfRounds(int total) {
        this.total = total;

        TotalNumberOfRoundsValidator.getInstance().validate(this);
    }

    public int getTotal() {
        return total;
    }
}
