package racingcar.controller;

import racingcar.model.Player;
import racingcar.view.InputView;

public class Game {
    private final Player player = new Player();
    private final InputView inputView = new InputView();

    public Game(){
       player.setCarName(inputView.askCarName());
       player.setAttemptNumber(inputView.askAttemptNumber());
    }
}
