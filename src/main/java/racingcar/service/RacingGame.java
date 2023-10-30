package racingcar.service;

import racingcar.model.Racer;
import racingcar.model.Round;

public class RacingGame {

    private final Racer racer;
    private final Round round;
    private final Accelerator accelerator = new Accelerator(); // TODO: 의존관계 주입 필요

    public RacingGame(Racer racer, Round round) {
        //TODO: racer도 정적 팩토리 메서드 고려
        this.racer = racer;
        this.round = round;
    }

    public Racer race() {
        racer.play(accelerator);
        round.turn();
        return racer;
    }

    public Boolean isEnd() {
        return round.hasRound();
    }
}
