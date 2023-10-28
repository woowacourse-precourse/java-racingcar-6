package racingcar;

import java.util.List;

public class RacingController {
    private final RacingCarInputView racingCarInputView;
    private final RacingCarOutputView racingCarOutputView;
    private final RacingCarInputValidator racingCarInputValidator;
    private final RacingCarService racingCarService;
    private final RacingCarAssemblyService racingCarAssemblyService;
    private final CarEngine carEngine;

    public RacingController(RacingCarInputView racingCarInputView, RacingCarOutputView racingCarOutputView,
                            RacingCarInputValidator racingCarInputValidator, RacingCarService racingCarService,
                            RacingCarAssemblyService racingCarAssemblyService, CarEngine carEngine) {
        this.racingCarInputView = racingCarInputView;
        this.racingCarOutputView = racingCarOutputView;
        this.racingCarInputValidator = racingCarInputValidator;
        this.racingCarService = racingCarService;
        this.racingCarAssemblyService = racingCarAssemblyService;
        this.carEngine = carEngine;
    }

    public void run() {
        List<String> carNames = getCarNamesFromUser();
        int attemptCounts = getAttemptCountsFromUser();
        Cars assembledCars = racingCarAssemblyService.assemble(carNames, carEngine);

        racingCarOutputView.printStartMessage();
        RacingResult racingResult = racingCarService.race(assembledCars, attemptCounts);

        racingCarOutputView.printEachRacingResult(racingResult);
        racingCarOutputView.printWinner(racingResult);
    }

    private int getAttemptCountsFromUser() {
        String attemptCounts = racingCarInputView.inputAttemptCounts();
        racingCarInputValidator.validateAttemptCounts(attemptCounts);
        return Integer.parseInt(attemptCounts);
    }

    private List<String> getCarNamesFromUser() {
        List<String> carNames = racingCarInputView.inputCarNames();
        racingCarInputValidator.validateCarNames(carNames);
        return carNames;
    }
}
