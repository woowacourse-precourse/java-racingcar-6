package controller;

import service.CarService;

import view.GameView;

public class GameController {

    private final GameView gameView;
    private final CarService carService;

    public GameController() {
        gameView = new GameView();
        carService = CarService.getInstance();
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

}
