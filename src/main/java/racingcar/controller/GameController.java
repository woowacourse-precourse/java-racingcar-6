package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.GameView;

public class GameController {
    private GameView gameView;
    private GameService gameService;

    public GameController() {
        this.gameView = new GameView();
        this.gameService = new GameService();
    }

    public void gameStart() {
        String[] carsName = gameView.inputCarsName();
        int numberGames = 5; // 자동차가 이동 할 회수를 입력 받는 기능을 구현하지 않아서 임의의 수를 입력함
        gameService.initGame(carsName, numberGames);
    }


}
