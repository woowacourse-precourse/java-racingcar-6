package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.Count;
import racingcar.model.RandomNumberGenerator;
import racingcar.repository.Track;

public class RacingCarService {

    private final Track track;
    public RacingCarService(Track track) {
        this.track = track;
    }

    public String play(Cars cars, Count count) {
        ready(cars);
        return go(cars, count);
    }

    private void ready(Cars cars) {
        track.init();
        cars.getCars().forEach(track::stand);
    }

    private String go(Cars cars, Count count) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.getCount(); i++) {
            drive(cars);
            sb.append(track);
        }
        return sb.toString();
    }

    private void drive(Cars cars) {
        cars.getCars().forEach(car -> track.move(car, RandomNumberGenerator.generateNumber()));
    }

    public String result() {
        return track.winners();
    }
}
