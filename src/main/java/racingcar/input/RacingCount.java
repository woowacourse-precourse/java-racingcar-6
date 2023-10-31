package racingcar.input;

import racingcar.output.MessageType;
import racingcar.output.OutputCarRace;

public class RacingCount {
    private int raceCount;

    public static RacingCount inputRaceCount(String stringMoveCount) {
        return new RacingCount(stringMoveCount);
    }

    public int getRaceCount() {
        return raceCount;
    }

    private RacingCount(String stringMoveCount) {
        OutputCarRace.printf(MessageType.INPUT_CAR_RACING_COUNT_PRINT);
        InputValidator.validateRaceCount(stringMoveCount);

        raceCount = Integer.parseInt(stringMoveCount);
        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringMoveCount);
    }
}
