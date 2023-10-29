package racingcar.domain;

import racingcar.message.ErrorMessage;

public class PositiveInteger {
    private int amount;
    public PositiveInteger(int amount) {
        validateTrial(amount);
        this.amount = amount;
    }

    private void validateTrial(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_COUNT);
        }
    }

    public boolean moreThen(int amount) {
        return this.amount > amount;
    }

    public void increment() {
        amount++;
    }

    public int getAmount() {
        return amount;
    }
}
