package racingcar.domain;

public class RacingGameManager {
    private CarManager carManager;
    private RacingGame racingGame;

    public RacingGameManager(CarManager carManager, RacingGame racingGame) {
        this.carManager = carManager;
        this.racingGame = racingGame;
    }

    public void start() {
        carManager.makeCar();
        racingGame.play();
    }
}
