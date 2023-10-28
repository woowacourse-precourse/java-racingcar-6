package racingcar.domain;

public class GameCount {
    private static final String NOT_A_NUMBER_MESSAGE = "게임 횟수는 숫자여야 합니다.";
    private static final String LESS_THAN_ONE_MESSAGE = "게임 횟수는 0 이상이어야 합니다.";

    private final int count;

    public GameCount(final String input) {
        this.count = validateAndParse(input);
    }

    private int validateAndParse(final String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 0) {
                throw new IllegalArgumentException(LESS_THAN_ONE_MESSAGE);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }
    }

}
