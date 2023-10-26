package controller;

import service.GameService;

import view.GameView;

public class GameController {

    private final GameView gameView;
    private final GameService gameService;

    public GameController() {
        gameView = new GameView();
        gameService = new GameService();
    }

    public void raceSet(String[] names) {
        gameView.printResult();
        gameService.fillNames(names);
    }

    public void race(int count) {
        String result = gameService.raceResult(count);
        gameView.printResult(result);
    }

    public void raceResult() {
        String winners = gameService.getWinners();
        gameView.printWinners(winners);
    }

}
