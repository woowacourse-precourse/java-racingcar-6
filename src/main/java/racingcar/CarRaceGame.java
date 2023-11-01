package racingcar;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.RaceJudge;
import racingcar.dto.MoveResults;
import racingcar.dto.WinnerNames;
import racingcar.generator.RandomNumberGenerator;
import racingcar.validator.InputMoveCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {

    private final RaceJudge judge = new RaceJudge();

    public void startRace() {
        addRaceCars();
        int moveCount = inputMoveCount();
        startMoveCars(moveCount);
        printWinner();
    }

    private void addRaceCars() {
        List<String> carNames = InputView.inputCarNames();
        judge.addCars(carNames);
    }

    private int inputMoveCount() {
        String inputMoveCount = InputView.inputMoveCount();
        InputMoveCountValidator.validateCount(inputMoveCount);
        return Integer.parseInt(inputMoveCount);
    }

    private void startMoveCars(final int moveCount) {
        Supplier<Integer> supplier = RandomNumberGenerator.getGenerateSupplier();
        for (int count = 1; count <= moveCount; count++) {
            judge.moveCars(supplier);
            printSingleMoveResult();
        }
    }

    private void printWinner() {
        WinnerNames names = judge.findAllWinnerNames();
        OutputView.printWinnerNames(names.toString());
    }

    private void printSingleMoveResult() {
        MoveResults singleMoveResults = judge.createSingleMoveResults();
        OutputView.printSingleMoveResult(singleMoveResults.toString());
    }
}
