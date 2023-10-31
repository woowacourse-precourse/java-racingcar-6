package racingcar.model;

import static racingcar.model.OutputConstants.INTEGER;
import static racingcar.model.SystemValueConstants.countMin;

public class RaceCountInput {

    private final int raceCount;

    private RaceCountInput(int raceCount) {
        this.raceCount = raceCount;
    }

    public static RaceCountInput createRaceCountInput(String userInput) {
        int userCount = valid(userInput);
        return new RaceCountInput(userCount);
    }

    private static int valid(String userInput) {
        validIsNumber(userInput);
        int userCount = toInt(userInput);
        validNotZero(userCount);
        return userCount;
    }

    private static void validIsNumber(String userInput) {
        if (!userInput.matches(INTEGER.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    private static void validNotZero(int userCount) {

        if (userCount < countMin()) {
            throw new IllegalArgumentException();
        }
    }

    private static int toInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    public int getRaceCount() {
        return raceCount;
    }
}
