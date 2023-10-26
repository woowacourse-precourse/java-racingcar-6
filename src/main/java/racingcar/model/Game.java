package racingcar.model;

public class Game {
    private Integer maxRoundNumber;
    private Integer presentRoundNumber;

    public Game(String s) {
        this.maxRoundNumber = validString(s);
        this.presentRoundNumber = 0;
    }

    private Integer validString(String s) {
        try {
            return maxRoundNumber = Integer.parseInt(s);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    public void roundNumberPlus() {
        this.presentRoundNumber++;
    }

    public Integer getMaxRoundNumber() {
        return maxRoundNumber;
    }

    public Integer getPresentRoundNumber() {
        return presentRoundNumber;
    }
}
