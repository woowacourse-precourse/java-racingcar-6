package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.Game;
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
        isPlaying(round);
    }

    public void showResultOfRound() {
        outputView.showOneRound(game.getGameResult());
    }

    public void printWinner() {
        Cars cars = game.getCars();
        ArrayList<String> winners = cars.findWinners();
        outputView.showWinners(winners);
    }

    private void isPlaying(int round) {
        while(game.stillInPlaying(round)) {
            game.running();
            showResultOfRound();
            round++;
        }
    }

}
