package racingcar.controller;

import racingcar.service.MoveStrategy;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TriesCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {
    private final MoveStrategy moveStrategy;
    private final CarNameValidator carNameValidator;
    private final TriesCountValidator triesCountValidator;
    private final WinnerService winnerService;

    public RacingGameController(MoveStrategy moveStrategy, CarNameValidator carNameValidator,
                                TriesCountValidator triesCountValidator, WinnerService winnerService) {
        this.moveStrategy = moveStrategy;
        this.carNameValidator = carNameValidator;
        this.triesCountValidator = triesCountValidator;
        this.winnerService = winnerService;
    }

    public void runRacingGame() {
        String carNameUserInput = InputView.askCarNames();
        List<String> carNames = carNameValidator.validateAndGetCarNames(carNameUserInput);
        String triesCountUserInput = InputView.askTriesCount();
        int triesCount = triesCountValidator.validateAndGetTriesCount(triesCountUserInput);
        List<Car> racingCars = initializeRacingCars(carNames, triesCount);
        displayCarMovements(triesCount, racingCars);
        displayWinners(racingCars);
    }

    private List<Car> initializeRacingCars(List<String> carNames, int triesCount) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            List<Boolean> movementFlags = moveStrategy.createMovementFlags(triesCount);
            racingCars.add(new Car(carName, movementFlags));
        }
        return racingCars;
    }

    private void displayCarMovements(int triesCount, List<Car> racingCars) {
        OutputView.printNewLine();
        OutputView.printResultMessage();
        IntStream.range(0, triesCount).forEach(moveIndex -> executeOneMove(racingCars));
    }

    private static void executeOneMove(List<Car> racingCars) {
        for (Car car : racingCars) {
            car.incrementMoveCount();
            OutputView.printMovements(car);
        }
        OutputView.printNewLine();
    }

    private void displayWinners(List<Car> racingCars) {
        List<Car> winners = winnerService.findWinners(racingCars);
        OutputView.printWinners(winners);
    }
}
