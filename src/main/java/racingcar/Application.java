package racingcar;

import racingcar.race.RaceManager;

public class Application {
    public static void main(String[] args) {
        RaceManager manager = new RaceManager();
        manager.startRace();
    }
}
