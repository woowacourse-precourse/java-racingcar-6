package racingcar.domain.wrapper;

import java.util.regex.Pattern;

public class RaceRound {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int numberOfRound;

    private RaceRound(int numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public static RaceRound create(String numberOfRoundString) {
        if (!NUMBER_PATTERN.matcher(numberOfRoundString).matches()) {
            throw new IllegalArgumentException();
        }
        return new RaceRound(Integer.parseInt(numberOfRoundString));
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
