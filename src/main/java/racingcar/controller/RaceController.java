package racingcar.controller;

import racingcar.model.data.Race;
import racingcar.view.RaceView;

public class RaceController {
    private Race race;
    private RaceView raceView;


    public RaceController(RaceView raceView) {
        this.raceView = raceView;
    }

    public void initRace() {}
    public void startRace() {}
    public void endRace() {}
}
