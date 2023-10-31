package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;

public class RaceController {
    RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }
    public void startRace() {
        HashMap<String, String> participants = InputView.inputParticipants();
        int round = InputView.inputRound();

        raceService.startRace(participants, round);

        OutputView.showFinalResultOf(participants);
    }
}
