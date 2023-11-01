package racingcar.controller;

import racingcar.service.MoveService;
import racingcar.service.RacingGameService;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TriesCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Car;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {
    private final CarNameValidator carNameValidator;
    private final TriesCountValidator triesCountValidator;
    private final RacingGameService racingGameService;

    public RacingGameController(MoveService moveService, CarNameValidator carNameValidator,
                                TriesCountValidator triesCountValidator, WinnerService winnerService) {
        this.carNameValidator = carNameValidator;
        this.triesCountValidator = triesCountValidator;
        this.racingGameService = new RacingGameService(moveService, winnerService);
    }

    public void startRacingGame() {
        String carNameUserInput = InputView.askCarNames();
        List<String> carNames = carNameValidator.validateAndGetCarNames(carNameUserInput);

        String triesCountUserInput = InputView.askTriesCount();
        int triesCount = triesCountValidator.validateAndGetTriesCount(triesCountUserInput);

        List<Car> racingCars = racingGameService.initializeRacingCars(carNames, triesCount);
        runRaces(triesCount, racingCars);

        List<Car> winners = racingGameService.findWinners(racingCars);
        OutputView.displayWinners(winners);
    }

    private void runRaces(int triesCount, List<Car> racingCars) {
        IntStream.range(0, triesCount).forEach(moveIndex -> {
            executeOneMove(racingCars);
            OutputView.displayCarsCurrentState(racingCars);
        });
    }

    private void executeOneMove(List<Car> racingCars) {
        for (Car car : racingCars) {
            car.incrementMoveCount();
        }
    }
}
