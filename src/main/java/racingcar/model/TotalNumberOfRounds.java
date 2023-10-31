package racingcar.model;

import racingcar.validator.model.ModelValidator;

public class TotalNumberOfRounds {
    private final int total;

    public TotalNumberOfRounds(int total) {
        this.total = total;

        (new ModelValidator()).validate(this);
    }

    public int getTotal() {
        return total;
    }
}
