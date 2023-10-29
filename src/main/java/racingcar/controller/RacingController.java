package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingResult;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputValidator;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RacingController {
    private final RacingCarInputView racingCarInputView;
    private final RacingCarOutputView racingCarOutputView;
    private final RacingCarInputValidator racingCarInputValidator;
    private final RacingCarService racingCarService;

    public RacingController(RacingCarInputView racingCarInputView, RacingCarOutputView racingCarOutputView,
                            RacingCarInputValidator racingCarInputValidator, RacingCarService racingCarService) {
        this.racingCarInputView = racingCarInputView;
        this.racingCarOutputView = racingCarOutputView;
        this.racingCarInputValidator = racingCarInputValidator;
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> carNames = getCarNamesFromUser();
        int attemptCounts = getAttemptCountsFromUser();

        racingCarOutputView.printStartMessage();
        RacingResult racingResult = racingCarService.race(carNames, attemptCounts);

        racingCarOutputView.printEachRacingResult(racingResult);
        racingCarOutputView.printWinner(racingResult);
    }

    private List<String> getCarNamesFromUser() {
        List<String> carNames = racingCarInputView.inputCarNames();
        racingCarInputValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getAttemptCountsFromUser() {
        String attemptCounts = racingCarInputView.inputAttemptCounts();
        racingCarInputValidator.validateAttemptCounts(attemptCounts);
        return Integer.parseInt(attemptCounts);
    }
}
