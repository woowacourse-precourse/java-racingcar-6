package racingcar.util.print.messages;

import static racingcar.util.print.constants.RacingGameConstants.RACE_START_MESSAGE;
import static racingcar.util.print.constants.RacingGameConstants.REQUEST_FOR_CAR_NAMES_MESSAGE;
import static racingcar.util.print.constants.RacingGameConstants.REQUEST_FOR_RACING_ROUNDS_MESSAGE;

public abstract class GameMessages {
    private GameMessages() {
    }

    private static void printer(String message)
    {System.out.println(message);}

    public static void printRequestForCarNames() {
        printer(REQUEST_FOR_CAR_NAMES_MESSAGE);
    }
    public static void printRequestForRacingRoundsMessage() {
        printer(REQUEST_FOR_RACING_ROUNDS_MESSAGE);
    }
    public static void printRaceStartMessage() {
        printer(RACE_START_MESSAGE);
    }
}
