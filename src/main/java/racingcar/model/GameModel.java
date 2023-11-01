package racingcar.model;

import racingcar.view.GameView;

import java.util.List;

public class GameModel {
    private GameView gameView;

    public List<String> getCarName() {
        return gameView.inputCarName();
    }

    public int getRounds() {
        return gameView.inputRounds();
    }
}
