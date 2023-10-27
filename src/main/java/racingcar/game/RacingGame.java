package racingcar.game;

import java.util.List;
import racingcar.collaborator.Race;
import racingcar.collaborator.generic.RaceProgress;
import racingcar.io.Output;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
        race.decideRound();

        race.run();
        List<RaceProgress> result = race.result();
        Output.consoleLine("실행 결과");
        Output.consoleLine(result);
    }

}
