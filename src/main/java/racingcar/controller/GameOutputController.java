package racingcar.controller;

import racingcar.Game;
import racingcar.view.OutputView;

public class GameOutputController {
    OutputView outputView;
    Game game;

    public void readyForGame(Game game) {
        outputView = new OutputView();
        this.game = game;
    }

    public void startGame() {
        int round = 1;
        outputView.showResultLog();
        while(round <= game.getChanceNumber()) {
            game.running();
            showResultOfRound();
            round++;
        }
    }

    public void showResultOfRound() {
        outputView.showOneRound(game.getGameResult());
    }

    //TODO: 최종 우승자 출력 요청

}
