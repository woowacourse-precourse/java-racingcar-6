package racingcar.domain.wrapper;

public class RaceRound {
    private final int numberOfRound;

    private RaceRound(int numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public static RaceRound create(String numberOfRoundString) {
        for (int i = 0; i < numberOfRoundString.length(); ++i) {
            char ch = numberOfRoundString.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException();
            }
        }
        return new RaceRound(Integer.parseInt(numberOfRoundString));
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
