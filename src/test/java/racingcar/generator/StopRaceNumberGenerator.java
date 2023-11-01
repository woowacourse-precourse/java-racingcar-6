package racingcar.generator;

import racingcar.util.RaceNumberGenerator;

public class StopRaceNumberGenerator implements RaceNumberGenerator {

    private final int STOP_RACE_NUMBER = 3;

    @Override
    public int generator() {
        return STOP_RACE_NUMBER;
    }
}
