package racingcar.controller;

import racingcar.service.RacingCarService;

import static racingcar.constant.StringConstant.*;

public class RacingCarGame {
    private final RacingCarService racingCarService;
    public RacingCarGame() {
        racingCarService = new RacingCarService();
    }

    public void run() {
        racingCarService.initCars();
        int round = racingCarService.initRound();
        System.out.print(OUTPUT_RESULT_MESSAGE.getMessage());
        for (int i = 0; i < round; i++) {
            racingCarService.move();
        }
        racingCarService.printWinner();
    }
}
