package racingcar.domain.wrapper;

import java.util.regex.Pattern;
import racingcar.domain.exception.BadRaceRoundException;

public class RaceRound {
    private static final int MIN_NUMBER_OF_ROUND = 1;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int numberOfRound;

    private RaceRound(int numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public static RaceRound create(String numberOfRoundString) {
        numberOfRoundString = numberOfRoundString.trim();
        if (!NUMBER_PATTERN.matcher(numberOfRoundString).matches()) {
            throw new BadRaceRoundException("숫자만 입력 가능합니다.");
        }
        int numberOfRound = Integer.parseInt(numberOfRoundString);
        if (numberOfRound < MIN_NUMBER_OF_ROUND) {
            throw new BadRaceRoundException(MIN_NUMBER_OF_ROUND + " 이상의 숫자만 입력 가능합니다.");
        }
        return new RaceRound(numberOfRound);
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }
}
