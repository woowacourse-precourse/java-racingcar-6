package racingcar;

import custom_object.Car;

import manager.GameManager;
import manager.GameInitializer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameInitializer gameInitializer = new GameInitializer();

        List<Car> carList = gameInitializer.inputCarName();
        int numberOfMatch = gameInitializer.inputNumbersOfMatch();

        GameManager gameManager = new GameManager(carList);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMatch; i++) {
            gameManager.progressMatch();
            gameManager.outputCurrentPosition();
            System.out.println();
        }

        gameManager.outputWinner();
    }
}
