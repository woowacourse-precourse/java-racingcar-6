package racingcar.service;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class RaceService {

    public List<Car> runRace(Race race) {
        race.run();
        return race.getCars();
    }

    public List<String> findWinners(Race race) {
        return race.findWinners();
    }
}
