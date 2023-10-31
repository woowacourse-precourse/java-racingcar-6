package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void start() {

        CarGroup carGroup = racingCarService.createCarGroup(InputView.printInputCarName());
        int roundNumber = racingCarService.getRoundNumber(InputView.printInputRound());

        outputView.printResultHeader();

        while (roundNumber != 0) {
            racingCarService.moveCarGroup(carGroup);
            outputView.printRoundResult(carGroup);
            roundNumber--;
        }

        outputView.printWinner(racingCarService.getWinners(carGroup));
    }
}
