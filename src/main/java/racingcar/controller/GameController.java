package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static RacingController racingController;

    public GameController(InputView inputView) {
        if (racingController == null) {
            racingController = new RacingController(inputView.getInformation());
        }
    }

    public void runGame(OutputView outputView) {
        playGame(outputView);
        outWinner(outputView);
    }

    private void playGame(OutputView outputView) {
        for (int i = 0; i < racingController.times; i++) {
            playRound(outputView);
        }
    }

    private void playRound(OutputView outputView) {
        racingController.go();
        outputView.printRoundResult(racingController.racingCars);
    }

    private void outWinner(OutputView outputView) {
        RacingCars winners = RacingCars.from(racingController.getMaxs());
        outputView.printWinnerResult(winners.getRacingCars());
    }
}
