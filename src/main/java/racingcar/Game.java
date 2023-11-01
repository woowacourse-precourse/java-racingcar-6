package racingcar;

import java.util.*;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private int gameCnt;

    public Game(String[] carNames, String gameCnt) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        if (!isNum(gameCnt)) {
            throw new IllegalArgumentException();
        }

        this.gameCnt = Integer.parseInt(gameCnt);

        if (this.gameCnt <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void race() {
        for (int i = 0; i < gameCnt; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car);
            }
            System.out.println();
        }
        printWinners();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private void printWinners() {
        List<Car> winners = getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        String winnerName = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + winnerName);
    }
}
