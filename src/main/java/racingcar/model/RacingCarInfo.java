package racingcar.model;

public class RacingCarInfo {
    private final String carName;
    public RacingCarInfo(String carName) {
        validataLength(carName);
        this.carName = carName;
    }

    private void validataLength(String carName) {
        if ((carName.isEmpty()) || (carName.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }
}
