package racingcar.model;

public class Game {
    private final MaxRoundNumber maxRoundNumber;
    private PresentRoundNumber presentRoundNumber;

    public Game(String s) {
        this.maxRoundNumber = new MaxRoundNumber(s);
        this.presentRoundNumber = new PresentRoundNumber(0);
    }

    public void roundNumberPlus() {
        this.presentRoundNumber = new PresentRoundNumber(presentRoundNumber.getRawPresentRoundNumber() + 1);
    }

    public MaxRoundNumber getMaxRoundNumber() {
        return maxRoundNumber;
    }

    public PresentRoundNumber getPresentRoundNumber() {
        return presentRoundNumber;
    }
}
