package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.repository.RaceRepository;

public class RaceService {

    private static RaceService raceService;
    RaceRepository raceRepository;

    private RaceService() {
        this.raceRepository = RaceRepository.getInstance();
    }

    public static RaceService getInstance() {
        if (raceService == null) {
            raceService = new RaceService();
        }
        return raceService;
    }


    public Race startRace(List<String> raceInfo) {
        String[] carNames = raceInfo.get(0).split(",");
        String chance = raceInfo.get(1);
        Race race = new Race(chance);
        for (String carName : carNames) {
            race.addCar(new Car(carName));
        }
        return raceRepository.saveRace(race);
    }

    public Race execRace() {
        Race race = raceRepository.findRace();
        race.exec();
        return race;
    }

    public int getChance() {
        return raceRepository.findRace().getChance();
    }
}
