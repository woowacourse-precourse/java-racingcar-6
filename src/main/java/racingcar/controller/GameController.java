package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    public static void startRacingCar(){
        GameService.startGame();
        GameService.playGame();
    }
}
