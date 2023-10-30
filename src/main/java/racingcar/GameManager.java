package racingcar;

import java.util.ArrayList;

public class GameManager {
    CarManager carManager = new CarManager();
    Raching raching;
    String[] carArray;
    ArrayList<Car> cars = new ArrayList<>();
    int maximomMove;
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
        carManager.printCarNamePrompt();
        carArray = carManager.inputForCarName();
        carConstructor();
        carManager.printCarMovePrompt();
        maximomMove = carManager.inputForCarMove();

        raching = new Raching(maximomMove);
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
