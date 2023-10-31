package racingcar.controller;

import racingcar.model.*;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {
    private RacingCarGameView racingCarGameView;
    private RacingCarGameService racingCarGameService;

    public RacingCarGameController() {
        racingCarGameView = new RacingCarGameView();
        racingCarGameService = new RacingCarGameService();
    }

    public void gameStart() {
        String input = racingCarGameView.inputCarNames();
        CarNames carNames = new CarNames(input);

        int count = racingCarGameView.inputTryCount();
        TryCount tryCount = new TryCount(count);

        RacingResult racingResult = new RacingResult(carNames, tryCount);

        while(tryCount.getCount() > 0) {
            racingResult = racingCarGameService.continueGame(racingResult);
            tryCount.decreaseCount();
            racingCarGameView.printResult(racingResult);
        }

        Winners winners = new Winners(racingResult.getWinners());
        racingCarGameView.printFinalResult(winners);
    }
}
