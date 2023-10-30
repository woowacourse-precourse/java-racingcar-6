package racingcar.service;

import racingcar.dto.Result;
import racingcar.model.Racer;
import racingcar.model.Round;

public class RacingGame {

    private final Racer racer;
    private final Round round;
    private final Accelerator accelerator = new Accelerator(); // TODO: 의존관계 주입 필요

    public RacingGame(Racer racer, Round round) {
        this.racer = racer;
        this.round = round;
    }

    public Result race() {
        racer.play(accelerator);
        round.turn();
        return racer.getResult();
    }

    public Boolean isEnd() {
        return round.hasRound();
    }

    public Result winner() {
        return racer.getWinner();
    }
}
