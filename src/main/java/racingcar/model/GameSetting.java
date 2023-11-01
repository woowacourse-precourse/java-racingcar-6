package racingcar.model;

public class GameSetting {
    private final Cars cars;
    private final Attempts attempts;

    public GameSetting(String carNames, String attempts) {
        this.cars = new Cars(carNames);
        this.attempts = new Attempts(attempts);
    }

    public Cars getCars() {
        return this.cars;
    }

    public Attempts getAttempts() {
        return this.attempts;
    }
}
