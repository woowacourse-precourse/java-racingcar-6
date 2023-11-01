package racingcar.io;

import racingcar.validation.Validation;

/**
 * Bundles functions related to input.
 * For each input, refines raw strings of user input into objects easy to deal with.
 */
public class InputAdaptor {
    private final InputReceiver inputReceiver;
    private final Parser parser;

    /**
     * Constructor.
     * @param inputReceiver object for getting input from the user.
     * @param parser object for parsing input.
     */
    public InputAdaptor(InputReceiver inputReceiver, Parser parser) {
        this.inputReceiver = inputReceiver;
        this.parser = parser;
    }

    /**
     * Reads and refines each names of cars from the user..
     * @return an array contains all the cars user has input in appropriate sequence.
     */
    public String[] readCarNames() {
        String carNamesInRaw = inputReceiver.readCarNames();
        String[] carNames = parser.parseCarNames(carNamesInRaw);
        Validation.checkCarNames(carNames);
        return carNames;
    }

    /**
     * Reads the number how many would try to proceed and parses it into integer.
     * @return the number of tries.
     */
    public int readNumOfTries() {
        String numOfTriesInRaw = inputReceiver.readNumOfTries();
        Validation.checkIfInteger(numOfTriesInRaw);
        int numOfTries = parser.parseInt(numOfTriesInRaw);
        Validation.checkIfNonNegative(numOfTries);
        return numOfTries;
    }
}
