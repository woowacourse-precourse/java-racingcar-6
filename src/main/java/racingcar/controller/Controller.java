package racingcar.controller;

public interface Controller {
    static RacingGameController generateRacingGameController() {
        return new RacingGameController();
    }
}
