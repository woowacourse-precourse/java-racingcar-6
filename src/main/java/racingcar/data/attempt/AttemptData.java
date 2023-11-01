package racingcar.data.attempt;

import java.util.List;

public class AttemptData {
    private final GameAttempts gameAttempts;
    private final AttemptIndex attemptIndex;
    private static final String WINNER_DELIMITER = ", ";

    public AttemptData() {
        this.gameAttempts = new GameAttempts();
        this.attemptIndex = new AttemptIndex();
    }

    public void initMoveAttempts(String racingCarNameData) {
        gameAttempts.createAttempt();
        gameAttempts.initBasicAttempt(racingCarNameData);
        attemptIndex.increase();
    }

    public void pickNewNumber() {
        gameAttempts.initNewAttempt(attemptIndex.toInt());
    }

    public void moveRacingCars() {
        gameAttempts.apply(attemptIndex.toInt());
    }

    public Attempt findLastAttemptByIndex() {
        return gameAttempts.findAttemptByIndex(attemptIndex.toInt());
    }

    public String findWinners() {
        List<String> Winners =  gameAttempts.findWinnersByIndex(attemptIndex.toInt());
        return String.join(WINNER_DELIMITER, Winners);
    }
}
