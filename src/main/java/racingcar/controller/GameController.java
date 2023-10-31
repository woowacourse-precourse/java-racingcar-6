package racingcar.controller;

import racingcar.view.RacingCar;

import java.io.IOException;

public class GameController {
    private final RacingCar racingCar;

    public GameController(RacingCar racingCar) {
        this.racingCar = racingCar;
    }


    public int GameStart(){
        racingCar.gameStart();
        return 0;
    }
}
