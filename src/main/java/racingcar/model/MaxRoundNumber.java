package racingcar.model;

public class MaxRoundNumber {
    private final int maxRoundNumber;

    public MaxRoundNumber(String maxRoundNumber) {
        this.maxRoundNumber = validString(maxRoundNumber);
    }

    private int validString(String s) {
        try {
            return Integer.parseInt(s);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getRawMaxRoundNumber() {
        return maxRoundNumber;
    }
}
