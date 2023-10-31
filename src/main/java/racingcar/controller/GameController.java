package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.*;
import racingcar.viewer.GameViewer;

public class GameController {
    private static final int MOVE_CONDITION = 4;
    private GameViewer viewer;
    private List<Car> cars;
    private Try coin;

    public GameController() {
        viewer = new GameViewer();
        cars = new ArrayList<>();
    }

    public void run() {
        readCarNames();
        readTheNumberOfTry();

        viewer.printStartMessage();

        while (coin.hasTry()) {
            coin.decrease();
            startGame();
            viewer.printRaceState(cars);
        }

        List<Car> winners = findWinners();
        viewer.printWinners(winners);
    }

    private void startGame() {
        for (Car car : cars) {
            if (canProgress()) {
                car.increaseStep();
            }
        }
    }

    private void readCarNames() {
        viewer.printAskCarNames();

        String line = Console.readLine();
        List<String> names = Arrays.asList(line.split(","));
        if (names.isEmpty()) {
            throw new IllegalArgumentException("잘못된 차 이름 입력");
        }

        for (String name : names) {
            Car newCar = new Car(name);
            cars.add(newCar);
        }
    }

    private void readTheNumberOfTry() {
        viewer.printAskTheNumberOfTry();

        int num;
        try {
            String line = Console.readLine();
            num = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 차 이름 입력");
        }

        coin = new Try(num);
    }

    private boolean canProgress() {
        int nextNumber = Randoms.pickNumberInRange(0, 9);
        return (nextNumber >= MOVE_CONDITION);
    }

    private List<Car> findWinners() {
        int max = -1;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getStep() == max) {
                winners.add(car);
            }
            if (car.getStep() > max) {
                max = car.getStep();
                winners.clear();
                winners.add(car);
            }
        }
        return winners;
    }
}
