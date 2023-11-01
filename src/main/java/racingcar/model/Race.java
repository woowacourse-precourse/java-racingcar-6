package racingcar.model;

import java.util.List;

public class Race {

    final List<Car> carRepository;
    final int raceRound;

    public Race(List<Car> carRepository, int raceRound) {
        this.carRepository = carRepository;
        this.raceRound = raceRound;
    }

    public List<Car> getCarRepository(){
        return carRepository;
    }

    public int getRaceRound(){
        return raceRound;
    }
}
