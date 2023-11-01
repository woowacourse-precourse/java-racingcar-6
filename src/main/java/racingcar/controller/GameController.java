package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarCreator;
import racingcar.model.User;
import racingcar.view.GameView;

import java.util.List;
import java.util.Random;

public class GameController {
    GameView gameView = new GameView();
    private final User user = new User();
    private List<Car> cars;

    public void startNewGame() {
        Integer tryCount = user.getUserInputForTryCount();
        String[] carNames = user.getUserInputForCarNames();

        cars = CarCreator.createCars(carNames);
    }

    // 0에서 9 사이의 무작위 값 생성. 4 이상이면 이동.
    public void moveCars() {
        Random random = new Random();
        for (Car car : cars) {
            int randomNumber = random.nextInt(10);
            if (randomNumber >= 4) {
                car.move();
            }
            gameView.printMoveStatus(car);
        }
    }

    public void printWinners() {
        List<Car> winnerCars = gameView.checkWinners(cars);
        gameView.printWinnerCars(winnerCars);
    }
}
