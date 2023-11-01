package racingcar.service;


import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RaceService {

    public Cars runRace(Race race) {
        race.run();
        return race.getCars();
    }

    public List<String> findWinners(Race race) {
        return race.findWinners();
    }
}
