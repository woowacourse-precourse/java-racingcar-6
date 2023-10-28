package racingcar;

public class GameRule {

    private int maxCarNameLength;
    private int minNumberInclude;
    private int maxNumberInclude;
    private int n;

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

    public int getN() {
        return n;
    }

    public void setNumberOfRepetitions(NumberOfRepetitions numBerOfRepetitions) {
        this.n = numBerOfRepetitions.getN();
    }
}
