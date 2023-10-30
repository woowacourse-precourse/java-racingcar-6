package racingcar.domain;

import java.util.StringJoiner;

public class WinnerStand {

    private static final String WINNER_DELIMITER = ", ";

    private final StringJoiner winners = new StringJoiner(WINNER_DELIMITER);
}
