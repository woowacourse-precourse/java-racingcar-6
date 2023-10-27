package racingcar.model;

public class PlayCount {

    private final int count;

    private PlayCount(final String count) {
        validateValue(count);
        this.count = Integer.parseInt(count);
    }

    public static PlayCount from(final String input) {
        return new PlayCount(input);
    }

    private void validateValue(final String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPlayEnd(final int number) {
        return count <= number;
    }
}
