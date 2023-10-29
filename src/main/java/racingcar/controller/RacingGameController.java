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

    public void racingGame() {
        List<Car> racingCars = new ArrayList<>();

        String carNameUserInput = InputView.askCarNames();
        String triesCountUserInput = InputView.askTriesCount();

        List<String> carNames = carNameValidator.validateAndGetCarNames(carNameUserInput);
        int triesCount = triesCountValidator.validateAndGetTriesCount(triesCountUserInput);

        for (String carName : carNames) {
            List<Boolean> movementFlags = moveStrategy.createMovementFlags(triesCount);
            racingCars.add(new Car(carName, movementFlags));
        }

        OutputView.printNewLine();
        OutputView.printResultMessage();

        // 메서드로 만들어서 stream 처리
        for (int completeMoves = 0; completeMoves < triesCount; completeMoves++) {
            for (Car car : racingCars) {
                car.incrementMoveCount();
                OutputView.printMovements(car);
            }
            OutputView.printNewLine();
        }

        List<Car> winners = winnerService.findWinners(racingCars);
        OutputView.printWinners(winners); //winner 객체로 뺄 지 고민 해보기
    }

}
