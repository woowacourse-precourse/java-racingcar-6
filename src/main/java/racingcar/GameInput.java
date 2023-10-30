package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static String inputCarsName() {
        return Console.readLine();
    }

    public static int raceTime() throws IllegalArgumentException {
        String raceTimeString = Console.readLine();
        if (!isStringConvertToInteger(raceTimeString)) {
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(raceTimeString);
    }

    private static boolean isStringConvertToInteger(String raceTimeString) {
        char[] raceTimeCharArray = raceTimeString.toCharArray();
        for (char raceTimeChar : raceTimeCharArray) {
            if (raceTimeChar < '0' || raceTimeChar > '9') {
                return false;
            }
        }
        return true;
    }

}
