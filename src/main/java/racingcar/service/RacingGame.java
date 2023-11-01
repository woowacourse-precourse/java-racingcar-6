package racingcar.service;

import java.util.*;
import java.util.stream.Collectors;

import racingcar.domain.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final List<Car> cars;
    private final int raceCount;
    private final OutputHandler outputHandler;

    public RacingGame(List<String> carNames, int raceCount, OutputHandler outputHandler) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.raceCount = raceCount;
        this.outputHandler = outputHandler;
    }

    public void start() {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                car.tryMove(Randoms.pickNumberInRange(0, 9));
            }
            outputHandler.printRaceResult(cars);
        }
    }

    public void printWinners() {
        int maxMove = getMaxMove();
        List<String> winners = cars.stream()
                .filter(car -> car.getMoveCount() == maxMove)
                .map(Car::getName)
                .collect(Collectors.toList());
        outputHandler.printWinners(winners);
    }

    private int getMaxMove() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}

