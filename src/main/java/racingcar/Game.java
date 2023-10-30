package racingcar;

public class Game {
    private final Cars cars;
    private final int tryCount;

    public Game(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            car.moveForward();
            car.printResult();
        }
        System.out.println();
    }
}
