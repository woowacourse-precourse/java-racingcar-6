package Service;

import Domain.Car;
import Domain.Game;
import View.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class GameService {
    public Game createGame() {
        String[] carNames = getCarName();
        int tryCount = getTryCount();
        Car[] cars = createCars(carNames);
        return new Game(cars, tryCount);
    }

    private String[] getCarName() {
        View.inputCars();
        String input = Console.readLine();
        return input.split(",");
    }

    private int getTryCount() {
        View.inputTryCount();
        return Integer.parseInt(Console.readLine());
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    /** 테스트용 **/
    public void testGetCarName() {
        View.inputCars();
    }

    public void testGetTryCount() {
        View.inputTryCount();
    }

    public Game testCreateGame() {
        String[] carNames = new String[]{"A, B, C"};
        int tryCount = 5;
        Car[] cars = createCars(carNames);
        return new Game(cars, tryCount);
    }
}

