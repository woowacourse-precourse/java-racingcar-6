package racingcar.service;

import racingcar.domain.Race;

public class RaceService {
    private final Race race;

    public RaceService() {
        this.race = new Race();
    }

    public void initializeRace(String attemptCountInput, String carNamesInput) {
        race.initializeRace(attemptCountInput, carNamesInput);
    }

    public void advanceRace() {
        race.advanceFullRound();
    }

}
