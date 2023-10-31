package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        List<Car> cars = game.createCars();
        int attempts = game.setAttempts();

        game.playGame(cars, attempts);
        game.printResult(cars);
    }
}
