package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static RacingGame game = new RacingGame();
    private GameView gameView = GameView.getInstance();

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return game;
    }

    public void startGame() {
        makeCarList();
    }

    public List<Car> makeCarList() {
        List<Car> cars = new ArrayList<>();
        String[] carNames = gameView.carsInput();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        for (Car car : cars) {
            System.out.println(car.getName());
        }
        return cars;
    }
}
