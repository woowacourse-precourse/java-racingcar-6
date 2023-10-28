package racingcar.model;

public class Advance {
    private boolean isAdvance;
    private int advanceCount;

    public Advance() {
    }

    public Advance(boolean isAdvance, int advanceCount) {
        this.isAdvance = isAdvance;
        this.advanceCount = advanceCount;
    }

    public boolean getIsAdvance() {
        return isAdvance;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }
}
