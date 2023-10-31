package controller;

import service.CarService;

import view.GameView;

public class GameController {

    private static GameController gameController;

    private final GameView gameView;
    private final CarService carService;

    private GameController() {
        gameView = GameView.getInstance();
        carService = CarService.getInstance();
    }

    public static GameController getInstance() {
        if(gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    public void raceSet(String[] names) {
        gameView.printResult();
        carService.fill(names);
    }

    public void race(int count) {
        String result = carService.getResult(count);
        gameView.printResult(result);
    }

    public void raceResult() {
        String winners = carService.getWinners();
        gameView.printWinners(winners);
    }

    public void close() {
        carService.close();
        gameView.close();
        gameController = null;
    }

}
