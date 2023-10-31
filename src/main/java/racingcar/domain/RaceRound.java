package racingcar.domain;

import static racingcar.config.RaceRoundConfig.*;
import static racingcar.exception.RaceRoundExceptionMessage.*;

public class RaceRound {


    private final int totalRound;
    private int currentRound;

    public RaceRound(final int totalRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        this.currentRound = INIT_CURRENT_GAME_ROUND_COUNT.getSetting();
    }

    public Boolean increaseCurrentRound() {
        Boolean increased = isLeftRound();
        if (increased) {
            this.currentRound++;
        }
        return increased;
    }

    public Boolean isLeftRound() {
        return currentRound < totalRound ? true : false;
    }


    private void validateTotalRound(final int totalRound) {
        if (totalRound < MIN_TOTAL_GAME_ROUND_COUNT.getSetting()) {
            throw new IllegalArgumentException(ERROR_TOTAL_GAME_ROUND_COUNT.getMessage());
        }
    }
}
