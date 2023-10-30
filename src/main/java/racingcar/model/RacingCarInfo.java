package racingcar.model;

public class RacingCarInfo {
    private static final int LENGTH_LIMIT = 5;

    public RacingCarInfo(String carName) {
        validataLength(carName);
    }

    private void validataLength(String carName) {
        if ((carName.isEmpty()) || (carName.length() > LENGTH_LIMIT)) {
            throw new IllegalArgumentException();
        }
    }
}
