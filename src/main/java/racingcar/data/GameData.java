package racingcar.data;

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
    }
}
