package racingcar.input;

import racingcar.output.MessageType;
import racingcar.output.OutputCarRace;

public class RacingCount {
    private int raceCount;

    public static RacingCount inputRaceCount(final String stringRaceCount) {
        return new RacingCount(stringRaceCount);
    }

    private RacingCount(final String stringRaceCount) {
        OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
        InputValidator.validateRaceCount(stringRaceCount);

        raceCount = Integer.parseInt(stringRaceCount);
        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringRaceCount);
    }

    public int getRaceCount() {
        return raceCount;
    }
}
