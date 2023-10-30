package racingcar.model;

public class RacingCarName {

    private static final int MAX_LENGTH = 5;

    public RacingCarName(String racingCarName) {
        validateLength(racingCarName);
    }

    private void validateLength(String racingCarName) {
        if (isInvalidLength(racingCarName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidLength(String racingCarName) {
        return (racingCarName.length() > MAX_LENGTH) || (racingCarName.isEmpty());
    }
}