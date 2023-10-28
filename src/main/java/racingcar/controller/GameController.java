package racingcar.controller;

import racingcar.model.RacingCarList;
import racingcar.view.*;

public class GameController {
    OutputView getMessage = new OutputView();
    InputView putMessage = new InputView();
    GameUtils gameUtility = new GameUtils();

    public void run() {
        getMessage.GameStartMessage();
        String namesOfRacingCars = putMessage.getPlayerInput();
        RacingCarList car = new RacingCarList(namesOfRacingCars);
        
    }
}
