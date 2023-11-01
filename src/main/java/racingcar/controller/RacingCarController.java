package racingcar.controller;

import racingcar.service.RacingCarService;

import java.util.List;


public class RacingCarController {

    private final RacingCarService carService = new RacingCarService();

    public void playGame() {

        //경주 할 자동차 이름
        List<String> carList = carService.InputCarName();

        //시도 할 횟수
        int gameAttemptCount = carService.getGameAttemptCount();

        //총 이동 결과
        int[] move = carService.playGame(gameAttemptCount, carList);

        //자동차 경주 승자
        carService.winner(carList,move);

    }

}
