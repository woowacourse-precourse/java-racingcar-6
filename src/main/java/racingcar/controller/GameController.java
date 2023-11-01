package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.GamePlayer;
import racingcar.domain.GameWinner;
import racingcar.domain.MoveCount;
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
        showWinner(gamePlayer);
    }

    private void showWinner(GamePlayer gamePlayer) {
        GameWinner gameWinner = gameService.createGameWinner(gamePlayer);
        outputView.gameWinner(gameWinner);
    }

    private void play(GamePlayer gamePlayer) {
        outputView.requestMoveCount();
        MoveCount moveCount = inputView.moveCount();
        outputView.beforeMovingMessage();
        moveRepeatByCount(moveCount, gamePlayer);
    }

    private void moveRepeatByCount(MoveCount moveCount, GamePlayer gamePlayer) {
        for (int i = 0; i < moveCount.getCount(); i++) {
            gameService.moveCars(gamePlayer);
            outputView.moveResult(gamePlayer);
        }
    }

    private GamePlayer start() {
        outputView.requestCarName();
        CarNames carNames = inputView.carNames();
        return gameService.createGamePlayer(carNames);
    }
}
