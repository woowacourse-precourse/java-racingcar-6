package racingcar;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final List<Car> cars;
    private final int raceCount;

    public RacingGame(List<String> carNames, int raceCount) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.raceCount = raceCount;
    }

    public void start() {
        System.out.println(" 실행 결과");
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                car.tryMove();
                System.out.println(car.getName() + " : " + car.getMove());
            }
            System.out.println();
        }
    }

    public void printWinners() {
        int maxMove = getMaxMove();

        List<String> winners = cars.stream()
                .filter(car -> car.getMoveCount() == maxMove)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxMove() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}

class Car {
    private final String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return move;
    }

    public String getMove() {
        return "-".repeat(move);
    }

    public void tryMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            move++;
        }
    }
}
