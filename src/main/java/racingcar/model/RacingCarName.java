package racingcar.model;

public class RacingCarName {

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        validate(racingCarName);
        this.racingCarName = racingCarName;
    }

    private void validate(String racingCarName) {
        if ((racingCarName.length() > 5) || (racingCarName.length() < 1)) {
            throw new IllegalArgumentException();
        }
    }
}
