package racingcar.domain;

/**
 * GameRound, GameCondition 나누기
 */
public class Game {
    public static int MAX_ROUND;
    private int currentRound;

    public Game(Integer maxRound) {
        MAX_ROUND = maxRound;
        currentRound = 0;
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
