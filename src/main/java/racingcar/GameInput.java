package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static String inputCarsName() {
        return Console.readLine();
    }

    public static int raceTime() {
        String raceTimeString = Console.readLine();
        return Integer.valueOf(raceTimeString);
    }

}
