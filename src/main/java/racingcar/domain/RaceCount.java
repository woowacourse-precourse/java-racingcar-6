package racingcar.domain;

public class RaceCount {
    static final String NUMBER_SIGN_ERROR = "[ERROR] 시도 횟수는 양수여야 합니다.";
    static private int totalCount;
    static private int currentCount;

    private RaceCount() {
    }

    static public void initializeByInput(String input) {
        totalCount = Integer.parseInt(input);
        validateTotalCount();
        currentCount = 0;
    }

    static private void validateTotalCount() {
        if (totalCount <= 0) {
            throw new IllegalArgumentException(NUMBER_SIGN_ERROR);
        }
    }

    static public boolean equalsTotal() {
        return (totalCount == currentCount);
    }

    static public void up() {
        currentCount++;
    }
}
