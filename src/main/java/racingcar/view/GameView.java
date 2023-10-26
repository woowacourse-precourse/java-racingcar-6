package racingcar.view;

import racingcar.controller.GameController;
import racingcar.model.Cars;
import racingcar.model.Game;

public class GameView {
    private final GameController gameController;
    private final Cars cars;
    private final Game game;
    public GameView(GameController gameController, Cars cars, Game game) {
        this.gameController = gameController;
        this.cars = cars;
        this.game = game;
        System.out.println("\n실행 결과");
        System.out.print(gameController.judge(cars, game));
        System.out.println("최종 우승자 : " + gameController.score(cars));
    }
}
