package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;

public class CarRaceTrack implements RaceTrack<Car>  {

    private final Racers<Car> racers;

    public CarRaceTrack(Racers<Car> racers) {
        this.racers = racers;
    }

    @Override
    public List<String> race(int repeat, Consumer<Car> consumer) {
        for (int i = 0; i < repeat; i++) {
            racers.raceOfOneCycle()
                    .forEach(consumer);
        }
        return racers.getMostMovementCarNames();
    }
}
