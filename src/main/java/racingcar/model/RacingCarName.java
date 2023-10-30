package racingcar.model;

public class RacingCarName {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        validateLength(racingCarName);
        this.racingCarName = racingCarName;
    }

    private void validateLength(String racingCarName) {
        if (isInvalidLength(racingCarName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidLength(String racingCarName) {
        return (racingCarName.length() > MAX_LENGTH) || (racingCarName.length() < MIN_LENGTH);
    }
}
