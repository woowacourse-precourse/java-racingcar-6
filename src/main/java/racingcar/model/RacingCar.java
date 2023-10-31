package racingcar.model;

public class RacingCar {
    private static final int LENGTH_LIMIT = 5;

    public RacingCar(String carName) {
        validataLength(carName);
    }

    private void validataLength(String carName) {
        if ((carName.isEmpty()) || (carName.length() > LENGTH_LIMIT)) {
            throw new IllegalArgumentException();
        }
    }
}
