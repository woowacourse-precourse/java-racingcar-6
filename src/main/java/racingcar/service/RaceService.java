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

    public void advanceRace(String inputAttemptCount) {
        int attemptCount = Integer.parseInt(inputAttemptCount);
        race.advanceFullRound(attemptCount);
    }

    public String selectWinners() {
        return race.selectWinners();
    }
}
