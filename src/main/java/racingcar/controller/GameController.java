package racingcar.controller;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Car> cars = new ArrayList<>();
    private List<String> raceHistory = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            String roundResult = "";
            for (Car car : cars) {
                car.move();
                roundResult += car.getName() + " : " + car.getPositionString() + "\n";
            }
            raceHistory.add(roundResult);
        }
    }

    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();
        for (Car car : cars) {
            positionString.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return positionString.toString();
    }

    public List<String> getRaceHistory() {
        return raceHistory;
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<String> getWinnersNames() {
        List<String> winnersNames = new ArrayList<>();
        List<Car> winners = getWinners();

        for (Car car : winners) {
            winnersNames.add(car.getName());
        }

        return winnersNames;
    }
}
