package racingcar;

import java.util.List;
import racingcar.domain.RaceJudge;
import racingcar.dto.MoveResult;
import racingcar.generator.MoveResultMessageGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.validator.InputTryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {

    private final RaceJudge judge = new RaceJudge();

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
        String inputRaceCount = InputView.inputRaceCount();
        InputTryCountValidator.validateCount(inputRaceCount);
        return Integer.parseInt(inputRaceCount);
    }

    private void startMoveCars(final int raceCount) {
        for (int count = 0; count < raceCount; count++) {
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
