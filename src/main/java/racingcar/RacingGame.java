package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.round.Round;

public class RacingGame {

    private static RacingGame game = new RacingGame();
    private GameView gameView = GameView.getInstance();
    private List<Car> cars;
    private Round round;

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return game;
    }

    public void startGame() {
        makeCarList();
        getRound();
    }

    public void makeCarList() {
        cars = new ArrayList<>();
        String[] carNames = gameView.carsInput();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }

    public void getRound() {
        String roundString = gameView.roundInput();
        round = new Round(roundString);

        System.out.println("round : " + round.getRound());
    }
}
