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
        //createGameRankBy(gamePlayer) 가 더 가독성이 좋은가
//        GameRank gameRank = gameService.createGameRank(gamePlayer);
        GameWinner gameWinner = gameService.createGameWinner(gamePlayer);
        outputView.gameWinner(gameWinner);
    }

    private void play(GamePlayer gamePlayer) {
        outputView.requestMoveCount();
        MoveCount moveCount = inputView.moveCount();
        //다른 네이밍은 없을까
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
        //inputView.carNames();
        //함수를 넣는것이 아닌 함수로 정보를 저장한뒤 저장한 인스턴스를 전달하는 과정은 어떤지
        //현재 GamePlayer가 inputView의 기능을 담당하고 있다고 봐도 되는 것인지
//        GamePlayer gamePlayer = gameService.initializePlayer(inputView.carNames());
        CarNames carNames = inputView.carNames();
        return gameService.createGamePlayer(carNames);
    }
}
