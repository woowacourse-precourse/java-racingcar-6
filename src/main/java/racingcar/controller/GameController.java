package racingcar.controller;

import racingcar.domain.GamePlayer;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/*
 *  사용자와 RacingCar게임간의 흐름을 담당
 * */

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        GamePlayer gamePlayer = start();
        play(gamePlayer);
    }

    private void play(GamePlayer gamePlayer) {
        outputView.requestMoveCount();
        gameService.moveCarsByCount(gamePlayer, inputView.moveCount());
        System.out.println(gamePlayer);

    }

    private GamePlayer start() {
        outputView.requestCarName();
        GamePlayer gamePlayer = gameService.settingPlayer(inputView.carNames());
        gamePlayer.printPlayerCars();
        return gamePlayer;
    }
}
