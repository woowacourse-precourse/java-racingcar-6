package constant;

public enum MagicNumbers {
    RANDOM_MIN(0), RANDOM_MAX(9), NUM_CHECK_GO(4);
    private final int Numbers;

    MagicNumbers(int Numbers) {
        this.Numbers = Numbers;
    }
    int getRandomNumbers() {
        return Numbers;
    }
}