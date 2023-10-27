package racingcar;

public class GameRule {

    private int maxCarNameLength;
    private int minNumberInclude;
    private int maxNumberInclude;

    public GameRule(int maxCarNameLength, int minNumberInclude, int maxNumberInclude) {
        this.maxCarNameLength = maxCarNameLength;
        this.minNumberInclude = minNumberInclude;
        this.maxNumberInclude = maxNumberInclude;
    }
    public int getMinNumberInclude() {
        return this.minNumberInclude;
    }

    public  int getMaxNumberInclude() {
        return this.maxNumberInclude;
    }
}
