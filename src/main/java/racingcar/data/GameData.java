package racingcar.data;

import racingcar.data.attempt.Attempt;
import racingcar.data.attempt.AttemptData;
import racingcar.data.attempt.AttemptNumber;

public class GameData {
    private final AttemptData attemptData;
    private AttemptNumber attemptNumber;

    public GameData() {
        this.attemptData = new AttemptData();
    }

    public void initAttemptData(String attemptNumberData) {
        int number = Integer.parseInt(attemptNumberData);
        attemptNumber = new AttemptNumber(number);
    }

    public void initRacingCarName(String racingCarNameData) {
        attemptData.initMoveAttempts(racingCarNameData);
    }

    public void proceedOneRace() {
        attemptData.pickNewNumber();
        attemptData.moveRacingCars();
    }

    public int getAttemptNumber() {
        return attemptNumber.toInt();
    }

    public Attempt findLastAttempt() {
        return attemptData.findLastAttemptByIndex();
    }

    public String produceResult() {
        return attemptData.findWinners();
    }
}
