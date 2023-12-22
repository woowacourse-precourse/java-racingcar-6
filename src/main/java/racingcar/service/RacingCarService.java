package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.Count;
import racingcar.repository.Track;

public class RacingCarService {

    private final Track track;
    public RacingCarService(Track track) {
        this.track = track;
    }

    public String play(Cars cars, Count count) {
        track.init();
        cars.ready(track);
        return count.moveByCount(track, cars);
    }

    public String result() {
        return track.winners();
    }
}
