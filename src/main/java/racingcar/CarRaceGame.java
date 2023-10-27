package racingcar;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.CarRaceJudge;
import racingcar.dto.MoveResult;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;

public class CarRaceGame {

    private final CarRaceJudge judge = new CarRaceJudge();

    public void startRace() {
        addRaceCars();
        int raceCount = inputRaceCount();
        moveCars(raceCount);
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

    private void moveCars(final int raceCount) {
        Supplier<Integer> randomNumberGenerator = RandomNumberGenerator::generateRandomNumber;
        for (int count = 0; count < raceCount; count++) {
            judge.moveCars(randomNumberGenerator);
        }
    }
}
