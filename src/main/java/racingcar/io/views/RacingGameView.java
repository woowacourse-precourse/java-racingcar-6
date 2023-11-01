package racingcar.io.views;

import java.util.List;
import racingcar.collaborator.race.Racer;
import racingcar.generic.RaceTotalProgress;

public class RacingGameView {

    private final RaceView raceView;
    public final RaceTotalProgressView raceTotalProgressView;

    public RacingGameView(RaceView raceView, RaceTotalProgressView raceTotalProgressView) {
        this.raceView = raceView;
        this.raceTotalProgressView = raceTotalProgressView;
    }

    public List<Racer> askRacersNames() {
        return raceView.askRacersNames();
    }

    public Integer askRoundNumber() {
        return raceView.askRoundNumber();
    }

    public void announceRacingRecordOn(RaceTotalProgress totalProgress) {
        raceTotalProgressView.announceRacingRecordOn(totalProgress);
    }

    public void announceWinnersOn(RaceTotalProgress totalProgress) {
        raceTotalProgressView.announceWinnersOn(totalProgress);
    }

}
