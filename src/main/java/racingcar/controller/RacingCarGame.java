package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarGame {
    private final RacingCarService racingCarService;
    public RacingCarGame() {
        racingCarService = new RacingCarService();
    }

    public void run() {
        racingCarService.initCars();
        int round = racingCarService.initRound();
        System.out.print("실행 결과\n");
        for (int i = 0; i < round; i++) {
            racingCarService.move();
        }
        racingCarService.printWinner();
    }
}
