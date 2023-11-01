package racingcar.repository;

import racingcar.domain.Race;

public class RaceRepository {

    private static RaceRepository raceRepository;
    Race race;

    private RaceRepository () {}

    public static RaceRepository getInstance() {
        if (raceRepository == null) {
            raceRepository = new RaceRepository();
        }
        return raceRepository;
    }

    public Race saveRace(Race race) {
        this.race = race;
        return race;
    }

    public Race findRace() {
        return race;
    }
}
