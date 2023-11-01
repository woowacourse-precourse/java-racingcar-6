package racingcar.domain;

public class RaceCount {
    private static RaceCount singletonInstance;
    private int totalCount;
    private int currentCount;

    private RaceCount() {
    }

    public static RaceCount getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new RaceCount();
        }
        return singletonInstance;
    }

    public boolean equalsTotal() {
        return (totalCount == currentCount);
    }

    public void up() {
        currentCount++;
    }

    public void initializeFromInput(String input) {
        totalCount = Integer.parseInt(input);
        validateTotalCount();

        currentCount = 0;
    }

    private void validateTotalCount() {
        if (totalCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NUMBER_SIGN.toString());
        }
    }
}
