package racingcar.game;

import racingcar.collaborator.Race;
import racingcar.io.Output;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
        race.decideRound();

        String result = race.run();
        Output.consoleLine("실행 결과");
        Output.consoleLine(result);
    }

}
