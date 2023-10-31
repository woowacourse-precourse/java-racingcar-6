package controllers;

import java.util.List;
import java.util.ArrayList;
import models.Car;
import views.ConsoleView;

public class GameController {
    private List<Car> cars;
    private ConsoleView view;

    public GameController(List<Car> cars, ConsoleView view) {
        this.cars = cars;
        this.view = view;
    }

    public void startGame(int tries) {
        for (int i = 0; i < tries; i++) {
            moveCars();
            view.displayGameState(cars);
        }

        List<String> winners = getWinners(cars);
        view.displayWinners(winners);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
