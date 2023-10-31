package racingcar.domain;

public class RaceCount {
    static private RaceCount singletonInstance;
    private int totalCount;
    private int currentCount;

    private RaceCount() {
        currentCount = 0;
    }

    static public RaceCount getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new RaceCount();
        }
        return singletonInstance;
    }

    public void initTotalCountFromInput(String input) {
        totalCount = Integer.parseInt(input);
        validateTotalCount();
    }

    private void validateTotalCount() {
        if (totalCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NUMBER_SIGN.toString());
        }
    }

    public boolean equalsTotal() {
        return (totalCount == currentCount);
    }

    public void up() {
        currentCount++;
    }
}
