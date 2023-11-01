package racingcar.model;

import racingcar.view.GameView;

import java.util.List;

public class GameModel {
    private final GameView gameView;

    public GameModel() {
        this.gameView = new GameView();
    }

    public List<String> getCarName() {
        return gameView.inputCarName();
    }

    public int getRounds() {
        return gameView.inputRounds();
    }
}
