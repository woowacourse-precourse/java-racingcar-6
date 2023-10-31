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

    public void GamePlay() {
        carManager.printCarNamePrompt();
        carArray = carManager.inputForCarName();
        carConstructor();
        carManager.printCarMovePrompt();
        maximomMove = carManager.inputForCarMove();
        int roundCount = 0;
        raching = new Raching(maximomMove);
        while (roundCount != maximomMove) {
            raching.generateRandomNumber(cars);
            raching.shouldMoveForward(cars);
            raching.RoundResultPrint(cars);
            roundCount++;
        }
        raching.ChampionPrint(cars);
    }
}
