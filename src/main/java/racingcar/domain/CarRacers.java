package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class CarRacers implements Racers<Car>{

    private List<Car> racers;

    public CarRacers(List<Car> racers) {
        this.racers = racers;
    }

    @Override
    public List<Car> raceOfOneCycle() {
        racers = this.racers.stream()
                .map(Car::move)
                .toList();
        return racers;
    }

    @Override
    public List<String> getMostMovementCarNames() {
        int mostMovementDistance = findMostMovementDistance();
        return this.racers.stream()
                .filter(car -> car.hasMovementDistanceOf(mostMovementDistance))
                .map(Car::getName)
                .toList();
    }

    private int findMostMovementDistance() {
        return this.racers.stream()
                .max(Comparator.comparingInt(Car::getMovementDistance))
                .orElseThrow(()-> new IllegalStateException("racers is empty"))
                .getMovementDistance();
    }
}
