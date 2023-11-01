package racingcar.model;

public class Round {

    private int round;

    /**
     * @param nonNegativeInteger
     * @throws IllegalArgumentException nonNegativeInteger < 0
     */
    public Round(int nonNegativeInteger) throws IllegalArgumentException {
        if (nonNegativeInteger < 0) {
            throw new IllegalArgumentException();
        }

        this.round = nonNegativeInteger;
    }
}
