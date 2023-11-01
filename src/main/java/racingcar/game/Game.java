package racingcar.game;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.util.Input;
import racingcar.util.Output;

import java.util.List;

public class Game {
    private Cars cars;

    public Game() {
        this.cars = new Cars();
    }

    public void doGame() {
        List<String> carNames = getCarNames();

        cars = makeCars(carNames);
        moveCars();
        endGame();
    }

    private static List<String> getCarNames() {
        Output.printWaitCarNames();
        return Input.readCarName();
    }

    private Cars makeCars(List<String> carNames) {
        Output.printWaitTryCount();

        Cars cars = new Cars();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.addCars(car);
        }

        return cars;
    }

    private void moveCars() {
        int tryCount = Input.readTryCount();
        Output.printAnnounce();

        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            Output.printResult(cars);
            Output.printSpace();
        }
    }

    private void endGame() {
        Output.printGameWinner(cars.getGameWinner());
    }
}
