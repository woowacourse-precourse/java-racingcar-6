package racingcar.domain;

import java.util.List;

public class CarRacers implements Racers<Car>{

    private List<Car> racers;

    public CarRacers(List<Car> racers) {
        this.racers = racers;
    }

    @Override
    public List<Car> raceOfOneCycle() {
        return null;
    }
}
