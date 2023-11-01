package racingcar.controller;

import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;
import racingcar.dto.UserAttemptCountsDto;
import racingcar.dto.UserCarNameDto;
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
        UserCarNameDto userCarNameDto = racingCarInputView.inputCarNames();
        UserAttemptCountsDto userAttemptCountsDto = racingCarInputView.inputAttemptCounts();
        racingCarService.initializeRacingGame(userCarNameDto, userAttemptCountsDto);
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
