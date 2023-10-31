package racingcar.controller;

import racingcar.service.GameService;
import racingcar.service.RacingCarGameService;

public class Controller {

    GameService racingCarGameService = new RacingCarGameService();

    public void racingCarGame(){
        racingCarGameService.Start();
        racingCarGameService.Progress();
        racingCarGameService.End();
    }



}
