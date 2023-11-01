package racingcar.model;

public class Race {
    final Car[] carRepository;
    final int raceRound;

    public Race(Car[] carRepository, int raceRound) {
        this.carRepository = carRepository;
        this.raceRound = raceRound;
    }
}
