package racingcar.domain;

public class PlayCount {

    private static final String PLAY_COUNT_DATA_TYPE_ERROR_MESSAGE = "게임 횟수는 1 이상의 수로 입력해야 합니다.";
    private static final String PLAY_COUNT_RANGE_ERROR_MESSAGE = "게임 횟수는 1회 이상이어야 합니다.";
    private int playCount;

    public PlayCount(String inputPlayCount) {
        validatePlayCount(inputPlayCount);
    }

    private void validatePlayCount(String inputPlayCount) {
        int playCount = validateCharacter(inputPlayCount);
        validateZeroNumber(playCount);
        this.playCount = playCount;
    }

    private int validateCharacter(String inputPlayCount) {
        try {
            return Integer.parseInt(inputPlayCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PLAY_COUNT_DATA_TYPE_ERROR_MESSAGE);
        }
    }

    private void validateZeroNumber(int playCount) {
        if (playCount <= 0) {
            throw new IllegalArgumentException(PLAY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public boolean canPlay(int currentCount) {
        return playCount > currentCount;
    }
}
