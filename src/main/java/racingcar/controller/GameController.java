package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class GameController {
    private GameController() {
    }

    private static class LazyHolder {
        public static final GameController instance = new GameController();
    }

    public static GameController getInstance(){
        return LazyHolder.instance;
    }

    public void newGame(){
        InputView inputView = new InputView();
        List<String> carList=inputView.carListInput();
        int numOfRound= inputView.numOfRoundInput();
    }
}
