package racingcar;

public class RaceInfo {
    private String[] carNames;
    private String attemptCount;

    public String[] getCarNames() {
        return carNames;
    }

    public String getAttemptCount() {
        return attemptCount;
    }

    public RaceInfo(String[] carNames, String attemptCount) {
        RaceInfoValidator.checkCarNameLength(carNames);
        RaceInfoValidator.hasMultipleCarNames(carNames);
        RaceInfoValidator.checkAttemptCount(attemptCount);
        this.carNames = carNames;
        this.attemptCount = attemptCount;
    }

}
