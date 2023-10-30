package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.Console.ExceptionMessage;
import racingcar.Console.Input;
import racingcar.Console.Output;
import racingcar.util.CarFactory;

public class RacingCarGame {

    private static final int MAX_GAME_TRY_COUNTS = 15;

    private List<Car> cars;

    {
        this.cars = new ArrayList<>();
    }

    public void playRacingCarGame() {
        this.cars = CarFactory.createCars(Input.receiveCarNames());
        int tryCounts = validateTryCounts(Input.receiveGameTryCounts());
        Output.printExecutionResultMessage();

        int idx = 0;
        while (idx < tryCounts) {
            moveRacingCar();
            printExecutionResult();
            idx++;
        }

        printFinalResult();
    }

    private void moveRacingCar() {
        for (Car car : this.cars) {
            car.tryMove();
        }
    }

    private static int validateTryCounts(String counts) {
        int tryCounts = 0;
        try {
            tryCounts = Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_GAME_TRY_COUNTS_FORMAT_MESSAGE);
        }

        if (tryCounts > MAX_GAME_TRY_COUNTS) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_GAME_TRY_COUNTS_SIZE_MESSAGE);
        }
        return tryCounts;
    }

    private void printExecutionResult() {
        Map<String, Integer> executionResultMap = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getMoveCounts));

        Output.printExecutionResult(executionResultMap);
    }

    private void printFinalResult() {

        List<String> winnerNames = new ArrayList<>();

        this.cars = this.cars.stream()
                .sorted(Comparator.comparing(Car::getMoveCounts).reversed())
                .collect(Collectors.toList());

        int maxMoveCounts = this.cars.get(0).getMoveCounts();

        for(Car car : this.cars) {
            if (car.getMoveCounts() == maxMoveCounts) {
                winnerNames.add(car.getName());
                continue;
            }
            break;
        }
        Output.printFinalResult(winnerNames);
    }
}
