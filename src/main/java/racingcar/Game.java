package racingcar;

import java.util.List;

public class Game {

    public static void start() {
        List<String> carNames = GameManager.enterCars();
        List<Car> cars = GameManager.generateCars(carNames);
        int attempt = GameManager.enterAttempt();
        System.out.println();


    }
}
