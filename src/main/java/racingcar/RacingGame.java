package racingcar;

import racingcar.collaborator.Race;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
    }

}
