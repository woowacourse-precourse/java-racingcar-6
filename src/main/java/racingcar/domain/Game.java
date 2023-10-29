package racingcar.domain;

public class Game {

    private final Cars cars;
    private final int tryCount;

    public Game(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount.getTryCount();
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            Output.printCarNameAndPosition(cars.getCarNamePositionMap());
        }
        Output.printVictoryCarNames(cars.getVictoryCarNames());
    }

    private void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (Utils.getRandomNumber() >= 4) {
                cars.moveCar(i);
            }
        }
    }
}
