package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarCreator;
import racingcar.model.User;
import racingcar.view.GameView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {
    GameView gameView = new GameView();
    private final User user = new User();
    private Integer tryCount = 0;
    private List<Car> cars;

    public void run() {
        String[] carNames = user.getUserInputForCarNames();
        tryCount = user.getUserInputForTryCount();
        cars = CarCreator.createCars(carNames);
    }

    // 0에서 9 사이의 무작위 값 생성. 4 이상이면 이동.
    public void moveCars() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveEachCar();
            System.out.println("");
        }
    }

    public void moveEachCar() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
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
