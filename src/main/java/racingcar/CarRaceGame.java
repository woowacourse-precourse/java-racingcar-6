package racingcar;

import static racingcar.generator.MoveResultMessageGenerator.generateMessage;
import static racingcar.generator.RandomNumberGenerator.getGenerateSupplier;

import java.util.List;
import racingcar.domain.CarRaceCountRule;
import racingcar.domain.CarRaceJudge;
import racingcar.dto.MoveResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {

    private final CarRaceJudge judge = new CarRaceJudge();

    public void startRace() {
        addRaceCars();
        int raceCount = inputRaceCount();
        startMoveCars(raceCount);
        printWinner();
    }

    private void addRaceCars() {
        List<String> carNames = InputView.inputCarNames();
        judge.addCars(carNames);
    }

    private int inputRaceCount() {
        String inputCount = InputView.inputRaceTryCount();
        CarRaceCountRule.validateCount(inputCount);
        return Integer.parseInt(inputCount);
    }

    private void startMoveCars(final int raceCount) {
        for (int count = 0; count < raceCount; count++) {
            judge.moveCars(getGenerateSupplier());
            printSingleMoveResult();
        }
    }

    private void printWinner() {
        List<String> winners = judge.findAllWinnerNames();
        OutputView.printWinners(winners);
    }

    private void printSingleMoveResult() {
        List<MoveResult> singleMoveResults = judge.createSingleMoveResults();
        String singleResult = generateMessage(singleMoveResults);
        OutputView.printSingleResult(singleResult);
    }
}
