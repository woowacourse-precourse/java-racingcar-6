package racingcar.domain;

import racingcar.message.ErrorMessage;

public class Position {
    private int amount;

    public Position(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE);
        }
    }

    public void increment(int speed) {
        amount += speed;
    }

    public int getAmount() {
        return amount;
    }
}
