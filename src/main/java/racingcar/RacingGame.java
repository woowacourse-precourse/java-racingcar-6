package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int moveNum) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < moveNum; i++) {
            for (Car car : cars) {
                car.move();
            }
            printGameState();
        }
    }

    public void printGameState() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}
