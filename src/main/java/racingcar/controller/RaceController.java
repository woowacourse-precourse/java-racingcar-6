package racingcar.controller;

import racingcar.dto.Players;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private static final RaceService raceService = new RaceService();




    public void raceStart(){

        Players players = InputView.getPlayersList();
        int attemptCount = InputView.getAttempt();

        raceSimulate(players, attemptCount);


    }
    private void raceSimulate(Players players, int attemptCount){


        do {
            raceService.raceOneSimulate(players);
        }while(attemptCount-->0);


    }


}
