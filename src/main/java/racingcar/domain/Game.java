package racingcar.domain;

import racingcar.view.Output;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private int attemptCount;

    public Game(String carNames, int numberOfAttempts) {
        initializeCars(carNames);
        this.attemptCount = numberOfAttempts;
    }

    /** carNames를 입력하면 이름들 사이의 공백은 제외하고 입력처리됨. */
    private void initializeCars(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            name = name.trim();
            cars.add(new Car(name));
        }
    }

    public void setGame() {
        currentCondition();
        isWinners();
    }

    private void currentCondition() {
        Output.attemptResultMessage();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            moveCars();
            printCurrentLocation();
            Output.newLine();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printCurrentLocation() {
        for (Car car : cars) {
            car.currentLocation();
        }
    }

    private void isWinners() {
        List<String> winners = new ArrayList<>();

        setWinners(winners);
        printWinners(winners);
    }

    private void setWinners(List<String> winners) {
        int maxForwardCount = 0;

        for (Car car : cars) {
            if (car.getForwardCount() > maxForwardCount) {
                maxForwardCount = car.getForwardCount();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }
    }

    private void printWinners(List<String> winners) {
        Output.winnerMessage();
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
