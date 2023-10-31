package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {

        CarGroup carGroup = racingCarService.createCarGroup(InputView.printInputCarName());
        int roundNumber = racingCarService.getRoundNumber(InputView.printInputRound());

        outputView.printResult();

        while (roundNumber != 0) {
            carGroup = racingCarService.moveCarGroup(carGroup);
            outputView.printRoundResult(carGroup);
            roundNumber--;
        }

        outputView.printWinner(racingCarService.getWinners(carGroup));
    }
}
