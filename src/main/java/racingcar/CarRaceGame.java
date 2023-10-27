package racingcar;

import static racingcar.generator.MoveResultMessageGenerator.generateMoveResultsMessage;
import static racingcar.generator.RandomNumberGenerator.getGenerateSupplier;

import java.util.List;
import racingcar.domain.CarRaceJudge;
import racingcar.dto.MoveResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {

    private final CarRaceJudge judge = new CarRaceJudge();

    public void startRace() {
        addRaceCars();
        int raceCount = inputRaceCount();
        startMoveCar(raceCount);
        printWinner();
    }

    private void printWinner() {
        List<String> winners = judge.findWinners();
        OutputView.printWinners(winners);
    }

    private int inputRaceCount() {
        String inputCount = InputView.inputRaceTryCount();
        CarRaceCountRule.validateCount(inputCount);
        return Integer.parseInt(inputCount);
    }

    private void addRaceCars() {
        List<String> carNames = InputView.inputCarNames();
        judge.addCars(carNames);
    }

    private void startMoveCar(final int raceCount) {
        for (int count = 0; count < raceCount; count++) {
            judge.moveCars(getGenerateSupplier());
            List<MoveResult> singleMoveResult = getSingleMoveResults();
            printSingleMoveResult(singleMoveResult);
        }
    }

    private List<MoveResult> getSingleMoveResults() {
        return judge.createSingleMoveResults();
    }

    private void printSingleMoveResult(final List<MoveResult> singleMoveResults) {
        String singleResult = generateMoveResultsMessage(singleMoveResults);
        OutputView.printSingleResult(singleResult);
    }
}
