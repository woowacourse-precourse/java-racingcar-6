package racingcar.model;

public class GameState {
    private AttempsCount attempsCount;
    private EndFlag endFlag;

    public GameState() {
        endFlag = new EndFlag();
    }

    public void updateAttempsCount(String attempsCount) {
        this.attempsCount = new AttempsCount(attempsCount);
    }

    public void increaseAttempsCount() {
        this.attempsCount.increaseAttempsCount();
    }

    public Boolean continueGame() {
        Boolean checkAttempsCount = this.attempsCount.checkCountEqualToMax();

        return !(this.endFlag.update(checkAttempsCount));
    }
}
