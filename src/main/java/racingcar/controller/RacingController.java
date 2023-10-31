package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingController {
    private final RacingCarInputView racingCarInputView;
    private final RacingCarOutputView racingCarOutputView;
    private final RacingCarService racingCarService;

    public RacingController(RacingCarInputView racingCarInputView, RacingCarOutputView racingCarOutputView,
                            RacingCarService racingCarService) {
        this.racingCarInputView = racingCarInputView;
        this.racingCarOutputView = racingCarOutputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        initializeGameByUserInput();
        raceAndPrintEachResult();
        printFinalWinners();
    }

    private void initializeGameByUserInput() {
        List<String> carNames = racingCarInputView.inputCarNames();
        String attemptCounts = racingCarInputView.inputAttemptCounts();
        racingCarService.initializeRacingGame(carNames, attemptCounts);
    }

    private void raceAndPrintEachResult() {
        racingCarOutputView.printStartMessage();
        while (racingCarService.isRemainAttemptCounts()) {
            RacingRoundResultDto racingRoundResultDto = racingCarService.race();
            racingCarOutputView.printEachRacingResult(racingRoundResultDto);
        }
    }

    private void printFinalWinners() {
        RacingResultDto racingResultDto = racingCarService.determineWinner();
        racingCarOutputView.printWinner(racingResultDto);
    }
}
