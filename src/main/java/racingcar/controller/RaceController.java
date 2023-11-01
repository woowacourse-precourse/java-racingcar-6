package racingcar.controller;

import racingcar.dto.Players;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private static final InputView inputView = new InputView();
    private static final RaceService raceService = new RaceService();
    private static final OutputView outputView = new OutputView();


    public void raceStart() {

        Players players = inputView.getPlayersList();
        int attemptCount = inputView.getAttempt();

        raceSimulate(players, attemptCount);

    }

    public void raceSimulate(Players players, int attemptCount) {

        players.attemptListInit();
        outputView.printFirstText();

        do {
            raceService.raceOneSimulate(players);
            outputView.printMiddleProcess(players);
        } while (--attemptCount > 0);

        outputView.printResult(players);

    }


}
