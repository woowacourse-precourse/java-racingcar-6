package racingcar;

import java.util.Scanner;

public class GameManager {
    private Cars cars;

    private int tryTimes;

    public void startRace(Scanner scanner) {
        createCar(scanner);
    }

    public void createCar(Scanner scanner) {
        initCar(scanner);
        initTryTimes(scanner);
    }


    private void initCar(Scanner scanner) {
    }

    private void initTryTimes(Scanner scanner) {
    }
}
