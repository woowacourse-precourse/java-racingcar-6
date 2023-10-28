package racingcar.Model;

public class GameStatus {
    private final Cars cars;
    private final int playCount;
    private int currentPlayCount;

    public GameStatus(Cars cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    private void nextStatus() {
        this.currentPlayCount += 1;
    }
}
