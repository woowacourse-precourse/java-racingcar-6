package racingcar.controller;

import racingcar.service.RacingCarService;

import java.util.List;


public class RacingCarController {

    RacingCarService carService = new RacingCarService();

    public void playGame() {

        //경주 할 자동차 이름
        List<String> carList = carService.InputCarName();

        //시도 할 횟수
        int gameAttemptCount = carService.getGameAttemptCount();

    }

}
