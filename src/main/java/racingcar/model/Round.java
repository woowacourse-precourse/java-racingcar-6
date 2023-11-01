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

    /**
     * @return 감소한 경우 true, 그렇지 않은 경우 false
     */
    public boolean decreaseByOne() {
        if (round >= 1) {
            round -= 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object round) {
        return (round instanceof Round) && (((Round) round).round == this.round);
    }
}
