package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarService {

    private Race race;

    public RacingcarService(Race race) {
        this.race = race;
    }

    public void raceRound() {
        race.raceRound();
    }

    public boolean isRaceFinished() {
        return race.isFinished();
    }

    public List<String> getWinner() {
        return race.getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getRaceStatus() {
        return race.getRaceStatus();
    }

}
