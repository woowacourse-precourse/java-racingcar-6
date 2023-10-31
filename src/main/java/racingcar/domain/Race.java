package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int raceCount;

    public Race(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void printRaceResult() {
        System.out.println("실행 결과");
        runRace();
        printWinners(getWinners());
    }

    private void runRace() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                car.move(randomNumberGenerator.generateRandomNumber());
            }
            printRace();
        }
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxMoveCount = -1;
        for (Car car : cars) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        if (winners.size() == 1) {
            System.out.println(winners.get(0));
        } else {
            for (int i = 0; i < winners.size() - 1; i++) {
                System.out.print(winners.get(i) + ", ");
            }
            System.out.println(winners.get(winners.size() - 1));
        }
    }

    private void printRace() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.generateMovement());
        }
        System.out.println();
    }

}
