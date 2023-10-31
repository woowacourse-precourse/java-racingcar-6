package racingcar.domain;

public class RaceCount {
    static private RaceCount singletonInstance;
    static private final String NUMBER_SIGN_ERROR = "[ERROR] 시도 횟수는 양수여야 합니다.";
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
            throw new IllegalArgumentException(NUMBER_SIGN_ERROR);
        }
    }

    public boolean equalsTotal() {
        return (totalCount == currentCount);
    }

    public void up() {
        currentCount++;
    }
}
