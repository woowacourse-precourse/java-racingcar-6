package racingcar.domain.input;

public class Input {
    private String carNames;
    private int racingCount;

    public Input(String carName, String racingCount) {
        this.carNames = carName;
        validateRacingCount(racingCount);
        this.racingCount = Integer.parseInt(racingCount);
    }

    private void validateRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Only numeric type");
        }
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRacingCount() {
        return racingCount;
    }
}
