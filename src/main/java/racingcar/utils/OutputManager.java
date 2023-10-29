package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class OutputManager {
    private static final String OUTPUT_MESSAGE = "실행 결과";

    public void printTotalResult(List<Car> cars, int roundNumber) {
        System.out.println(OUTPUT_MESSAGE);
        for (int i = 0; i < roundNumber; i++) {
            printRoundResult(cars);
        }
    }

    public void printRoundResult(List<Car> cars) {
        cars.stream().forEach(
                car -> {
                    System.out.println(car);
                }
        );
    }
}
