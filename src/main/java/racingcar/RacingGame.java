package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        initializeCars(carNames);
    }

    public void runGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            raceOneRound();
            printRoundResult();
        }

        announceWinners();
    }

    private void initializeCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private void raceOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            car.printPosition();
        }
        System.out.println();
    }

    private void announceWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = findWinners(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
