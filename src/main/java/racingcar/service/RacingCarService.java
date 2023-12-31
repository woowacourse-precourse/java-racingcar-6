package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.Count;
import racingcar.repository.Track;

public class RacingCarService {
    private final Track track;

    public RacingCarService(Track track) {
        this.track = track;
    }

    public void play(Cars cars, Count count) {
        track.ready(cars);
        track.go(count);
    }

    public Track getTrack() {
        return track;
    }

    public Cars getWinners() {
        return new Cars(track.findWinners());
    }
}
