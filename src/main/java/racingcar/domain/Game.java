package racingcar.domain;

/**
 * GameRound, GameCondition 나누기
 */
public class Game {
    public static int MAX_CAR_NUMBER;
    public static int MAX_ROUND;
    private int currentRound;

    public Game(Integer maxCarNumber, Integer maxRound) {
        MAX_CAR_NUMBER = maxCarNumber;
        MAX_ROUND = maxRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void increaseCurrentRound() {
        currentRound += 1;
    }

    public boolean isMeetCondition(int number) {
        return number >= 4;
    }
}
