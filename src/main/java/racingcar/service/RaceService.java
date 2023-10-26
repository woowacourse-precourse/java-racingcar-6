package racingcar.service;

import racingcar.domain.Race;
import racingcar.dto.CarCondition;
import racingcar.dto.RaceResult;

public class RaceService {
    private static RaceService raceService;
    private static Race race;

    public void initRace(String carNames) {
        race = new Race(carNames);
    }

    public CarCondition proceed() {
        return null;
    }

    public RaceResult end() {
        return null;
    }

    public static RaceService getInstance() {
        if (raceService == null) {
            raceService = new RaceService();
        }
        return raceService;
    }

    private RaceService() {}
}
