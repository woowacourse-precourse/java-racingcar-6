package racingcar;

import racingcar.controller.RaceGameController;

public class Application {
    public static void main(String[] args) {
        RaceGameController raceGame = new RaceGameController();
        raceGame.StartRaceGame();
    }
}
