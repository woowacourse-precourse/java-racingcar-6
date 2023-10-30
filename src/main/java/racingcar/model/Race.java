package racingcar.model;

public class Race {

    private final Cars cars;
    private final GameCount gameCount;

    private Race(Cars cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public static Race of(Cars cars, GameCount gameCount) {
        return new Race(cars, gameCount);
    }

    public void start() {
        while (!gameCount.isGameOver()) {
            gameCount.run();
            cars.run();
            printProcess();
        }
    }

    private void printProcess() {
        
    }

    public void printResult() {

    }
}
