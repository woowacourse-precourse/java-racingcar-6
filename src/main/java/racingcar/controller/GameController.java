package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.OutputView;

public class GameController {

    public static void startRacingCar(){

        GameService.startGame();
        GameService.playGame();
        GameService.endGmae();

    }


}
