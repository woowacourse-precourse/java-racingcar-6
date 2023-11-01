package racingcar;

import java.util.List;

/**
 * 자동차 경주 결과
 */
public class GameResult {

    private List<RacingCar> winners;

    public GameResult(List<RacingCar> winners) {
        this.winners = winners;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
