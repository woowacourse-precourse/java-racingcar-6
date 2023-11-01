package racingcar.domain;

public class PlayCount {

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
            throw new IllegalArgumentException();
        }
    }

    private void validateZeroNumber(int playCount) {
        if (playCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean canPlay(int currentCount) {
        return playCount > currentCount;
    }
}
