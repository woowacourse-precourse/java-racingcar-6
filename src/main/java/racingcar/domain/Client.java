package racingcar.domain;

import racingcar.util.ClientValidator;

public class Client {
    private final int tryNumber;

    public Client(String inputtedTryNumber) {
        this.tryNumber = ClientValidator.getValidatedIntValue(inputtedTryNumber);
    }

    public int getTotalRounds() {
        return tryNumber;
    }
}
