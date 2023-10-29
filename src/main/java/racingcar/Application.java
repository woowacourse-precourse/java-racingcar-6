package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.race.RaceController;
import racingcar.domain.race.RaceService;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = RaceController.createRaceController(RaceService.getInstance());

        raceController.startRaceGame();
        Console.close();
    }
}
