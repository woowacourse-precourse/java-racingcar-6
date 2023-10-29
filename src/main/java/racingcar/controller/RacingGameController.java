package racingcar.controller;

import racingcar.service.MoveStrategy;
import racingcar.service.WinnerDeterminationService;
import racingcar.validator.CarNameInputValidator;
import racingcar.validator.TriesCountInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private final MoveStrategy moveStrategy;
    private final CarNameInputValidator carNameInputValidator;
    private final TriesCountInputValidator triesCountInputValidator;
    private final WinnerDeterminationService winnerDeterminationService;

    public RacingGameController(MoveStrategy moveStrategy, CarNameInputValidator carNameInputValidator, TriesCountInputValidator triesCountInputValidator, WinnerDeterminationService winnerDeterminationService) {
        this.moveStrategy = moveStrategy;
        this.carNameInputValidator = carNameInputValidator;
        this.triesCountInputValidator = triesCountInputValidator;
        this.winnerDeterminationService = winnerDeterminationService;
    }

    public void racingGame() {
        List<Car> racingCars = new ArrayList<>();

        String carNameUserInput = InputView.askCarNames();
        String triesCountUserInput = InputView.askTriesCount();

        List<String> carNames = carNameInputValidator.validateAndGetCarNames(carNameUserInput);
        int triesCount = triesCountInputValidator.validateAndGetTriesCount(triesCountUserInput);

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

        List<Car> winners = winnerDeterminationService.findWinners(racingCars);
        OutputView.printWinners(winners); //winner 객체로 뺄 지 고민 해보기
    }

}
