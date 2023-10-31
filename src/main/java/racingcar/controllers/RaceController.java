package racingcar.controllers;

import java.util.List;

import racingcar.models.RaceService;
import racingcar.models.RacingCar;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RaceController {
    private InputView inputView;
    private OutputView outputView;
    private RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void progress() {
        List<RacingCar> racingCars = inputView.getRacingCars();
        int roundNumber = inputView.getRoundNumber();
        System.out.println("실행 결과");
        for (int round = 0; round < roundNumber; round++) {
            raceService.progressRound(racingCars);
            outputView.printRoundResult(racingCars);
        }
        List<RacingCar> winners = raceService.getWinners(racingCars);
        outputView.printRaceResult(winners);
    }
}
