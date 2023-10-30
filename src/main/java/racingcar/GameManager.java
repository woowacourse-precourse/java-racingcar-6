package racingcar;

import java.util.ArrayList;

public class GameManager {
    final CarManager carManager = new CarManager();
    final Raching raching = new Raching();
    String[] carArray = carManager.inputForCarName();
    ArrayList<Car> cars = new ArrayList<>();
    final int maximomMove = carManager.inputForCarMove();
    public void carConstructor() {
        for (String name : carArray) {
            cars.add(new Car(name.trim()));
        }
    }

    public boolean isMaximomMove(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.moveCount == maximomMove) {
                return true;
            }
        }
        return false;
    }

    public void GamePlay() {
        carConstructor();
        while (true) {
            if (isMaximomMove(cars)) {
                raching.ChampionPrint(cars);
                break;
            }
            raching.generateRandomNumber(cars);
            raching.shouldMoveForward(cars);
            raching.RoundResultPrint(cars);
        }
    }
}
