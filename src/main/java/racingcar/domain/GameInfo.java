package racingcar.domain;

import racingcar.domain.round.Round;

public class GameInfo {

    private final RacingCarDrivers racingCarDrivers;
    private final Round round;

    public GameInfo(String drivers, String roundNumber) {
        this.racingCarDrivers = new RacingCarDrivers(drivers);
        this.round = new Round(roundNumber);
    }

    public String[] getRacingCarDrivers() {
        return racingCarDrivers.getRacingCarDriversArray();
    }

    public int getRound() {
        return round.getRound();
    }
}