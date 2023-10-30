package racingcar.game;

import racingcar.collaborator.race.Race;
import racingcar.generic.RaceTotalProgress;
import racingcar.io.views.RacingGameView;

public class RacingGame {

    private final RacingGameView racingGameView;
    private final Race race;

    public RacingGame(RacingGameView racingGameView, Race race) {
        this.racingGameView = racingGameView;
        this.race = race;
    }

    public void play() {
        prepareRace();
        race.run();
        performRacingGameFinale();
    }

    private void prepareRace() {
        race.registerRacer(racingGameView.askRacersNames());
        race.decideRoundNumber(racingGameView.askRoundNumber());
    }

    private void performRacingGameFinale() {
        RaceTotalProgress totalProgress = race.getTotalProgress();
        racingGameView.announceRacingRecordOn(totalProgress);
        racingGameView.announceWinnersOn(totalProgress);
    }

}
