package racingcar.generator;

import racingcar.util.RaceNumberGenerator;

public class MoveRaceNumberGenerator implements RaceNumberGenerator {

    private final int MIN_MOVE_RACE_NUMBER = 4;

    @Override
    public int generator() {
        return MIN_MOVE_RACE_NUMBER;
    }
}
