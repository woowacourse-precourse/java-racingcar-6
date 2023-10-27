package racingcar;

import racingcar.manager.RaceManager;

public class Application {
    public static void main(String[] args) {

        RaceManager raceManager = new RaceManager();
        raceManager.start();
    }
}
