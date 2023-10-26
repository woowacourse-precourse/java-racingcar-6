package controller;

import view.GameView;

public class GameController {

    private final GameView gameView;

    public GameController() {
        gameView = new GameView();
    }

    public void raceStart(String[] name, int count) {
        gameView.printResult();

    }

}
