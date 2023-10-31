package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = RaceController.getInstance(RaceService.getInstance());

        raceController.startRaceGame();
        Console.close();
    }
}
