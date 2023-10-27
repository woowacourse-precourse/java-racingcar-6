package racingcar.game;

import racingcar.collaborator.Race;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
        race.decideRound();

        String result = race.run();
        System.out.println(result);

    }

}
