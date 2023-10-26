package racingcar.model;

public class Game {
    private Long maxRoundNumber;
    private Long presentRoundNumber;

    public Game(String s) {
        this.maxRoundNumber = validString(s);
        this.presentRoundNumber = 0L;
    }

    public Long getMaxRoundNumber() {
        return maxRoundNumber;
    }

    private Long validString(String s) {
        try {
            return maxRoundNumber = Long.parseLong(s);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
