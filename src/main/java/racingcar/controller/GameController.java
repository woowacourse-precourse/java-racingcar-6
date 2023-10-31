package racingcar.controller;

import racingcar.service.GameService;
public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        int runChance = start();
        finish(runChance);
    }

    public int start(){
        gameService.enterCar();
        int runChance = gameService.enterChance();
        return runChance;
    }

    public void finish(int chance) {
        gameService.gameResult(chance);
        gameService.winnerList();
    }
}
