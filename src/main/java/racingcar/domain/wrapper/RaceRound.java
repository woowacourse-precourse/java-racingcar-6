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
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        int numberOfRound = Integer.parseInt(numberOfRoundString);
        if (numberOfRound <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력 가능합니다.");
        }
        return new RaceRound(numberOfRound);
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
