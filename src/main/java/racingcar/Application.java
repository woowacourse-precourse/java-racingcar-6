package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        raceController.startRace();
        Console.close();
    }
}