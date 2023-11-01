package racingcar.controller;

import racingcar.dto.Players;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private static final RaceService raceService = new RaceService();
    private static final OutputView outputView = new OutputView();



    public void raceStart(){

        Players players = InputView.getPlayersList();
        int attemptCount = InputView.getAttempt();

        raceSimulate(players, attemptCount);


    }
    private void raceSimulate(Players players, int attemptCount){

        players.attemptListInit();
        outputView.printFirstText();

        do {
            raceService.raceOneSimulate(players);
            outputView.printMiddleProcess(players);
        }while(--attemptCount>0);

        outputView.printResult(players);

    }


}
