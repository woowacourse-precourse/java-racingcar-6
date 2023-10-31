package racingcar;

import java.util.List;
import racingcar.domain.RaceJudge;
import racingcar.dto.MoveResult;
import racingcar.generator.MoveResultMessageGenerator;
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
        for (int count = 1; count <= moveCount; count++) {
            judge.moveCars(RandomNumberGenerator.getGenerateSupplier());
            printSingleMoveResult();
        }
    }

    private void printWinner() {
        List<String> winners = judge.findAllWinnerNames();
        OutputView.printWinners(winners);
    }

    private void printSingleMoveResult() {
        List<MoveResult> singleMoveResults = judge.createSingleMoveResults();
        String singleResult = MoveResultMessageGenerator.generateMessage(singleMoveResults);
        OutputView.printSingleResult(singleResult);
    }
}
