package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private InputManager inputManager;
    List<RandomCar> randomCars = new ArrayList<>();

    public GameManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public void launch() {
        List<String> names = inputManager.inputCarNames();

        createRandomCars(names);

        int attemptNumber = inputManager.inputMoveNumber();

        moveRandomCars(attemptNumber);
    }

    private void createRandomCars(List<String> names) {
        names.forEach(name -> randomCars.add(new RandomCar(name)));
    }

    private void moveRandomCars(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            for (RandomCar randomCar : randomCars) {
                randomCar.move();
                randomCar.printPosition();
            }
            System.out.println();
        }
    }
}
