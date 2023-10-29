package racingcar.vo;

public class RacingPreference {

    private String[] cars;
    private int attempt;

    public RacingPreference(String[] cars, int attempt) {
        this.cars = cars;
        this.attempt = attempt;
    }

    public String[] getCars() {
        return cars;
    }

    public int getAttempt() {
        return attempt;
    }
}
