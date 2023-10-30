package racingcar.controller;

import racingcar.service.GameService;
public class GameController {
    private GameService gameService = new GameService();

    public void play() {
        int runChance = run();
        finish(runChance);
    }

    public int run(){
        gameService.enterCar();
        int runChance = gameService.enterChance();
        return runChance;
    }

    public void finish(int chance) {
        gameService.gameResult(chance);
        gameService.winnerList();
    }
}
