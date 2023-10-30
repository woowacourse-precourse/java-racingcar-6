package racingcar.io;

import racingcar.validation.Validation;

public class InputAdaptor {
    private final InputReceiver inputReceiver;
    private final Parser parser;

    public InputAdaptor(InputReceiver inputReceiver, Parser parser) {
        this.inputReceiver = inputReceiver;
        this.parser = parser;
    }

    public String[] readCarNames() {
        String carNamesInRaw = inputReceiver.readCarNames();
        String[] carNames = parser.parseCarNames(carNamesInRaw);
        Validation.checkCarNames(carNames);
        return carNames;
    }

    public int readNumOfTries() {
        String numOfTriesInRaw = inputReceiver.readNumOfTries();
        Validation.checkIfInteger(numOfTriesInRaw);
        int numOfTries = parser.parseInt(numOfTriesInRaw);
        Validation.checkIfNonNegative(numOfTries);
        return numOfTries;
    }
}
