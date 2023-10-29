package racingcar.domain.racingcargame;

import racingcar.domain.attempt.Attempt;
import racingcar.domain.cars.Players;
import racingcar.domain.cars.Winners;

public class RacingCarGame {

    private static final String ERROR_MESSAGE_CANNOT_RACE = "더 이상 게임을 진행할 수 없습니다.";

    private final Players players;
    private final Attempt attempt;

    public RacingCarGame(Players players, Attempt attempt) {
        this.players = players;
        this.attempt = attempt;
    }

    public void race() {
        if (!attempt.hasNext()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CANNOT_RACE);
        }
        players.moveAll();
        attempt.use();
    }

    public boolean hasNext() {
        return attempt.hasNext();
    }

    public Winners winners() {
        return Winners.judge(players);
    }
}
