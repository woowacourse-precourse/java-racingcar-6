package racingcar.Controller;

import racingcar.Service.GameService;

public class GameController {
    public static void startRacingCar()
    {
        GameService.startRacingCar();
        GameService.playRacingCar();
    }
}
