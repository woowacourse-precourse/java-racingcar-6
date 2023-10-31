package racingcar.domain.game;

import racingcar.domain.car.CarInfo;
import racingcar.dto.Round;

public class GameRound {
    private static final CarInfo carInfo = CarInfo.getInstance();

    private Round currentRound;

    public GameRound(Round round) {
        currentRound = round;
    }

    public Integer passAndGetCurrentRound() {
        this.currentRound = new Round(currentRound.round() + 1);
        return currentRound.round();
    }

}
