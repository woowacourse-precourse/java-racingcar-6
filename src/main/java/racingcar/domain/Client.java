package racingcar.domain;

import racingcar.util.ClientValidator;

import java.math.BigInteger;

public class Client {
    private final BigInteger tryNumber;

    public Client(String inputtedTryNumber) {
        this.tryNumber = ClientValidator.getValidatedBigIntegerValue(inputtedTryNumber);
    }

    public BigInteger getTotalRounds() {
        return tryNumber;
    }
}
