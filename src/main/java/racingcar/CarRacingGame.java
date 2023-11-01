package racingcar;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import static racingcar.InputHandler.getInteger;
import static racingcar.InputHandler.initCars;

public class CarRacingGame {
    public void run() {
        List<Car> cars = initCars();
        int tryCount = getInteger();
        runningProcess(cars, tryCount);
        int maxScore = getMaxScore(cars);
        List<String> winner = getWinners(cars, maxScore);
        printWinners(winner);
    }

    protected void runningProcess(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            String tryResult = getProcessResultAsString(cars);
            System.out.println(tryResult);
        }
    }

    private String getProcessResultAsString(List<Car> cars) {
        StringBuilder processString = new StringBuilder();
        cars.forEach(car -> {
            car.updateScore();
            processStringBuilderWriter(processString, car);
        });
        return processString.toString();
    }

    private void processStringBuilderWriter(StringBuilder processString, Car car) {
        processString.append(car.getName()).append(" : ");
        processString.append("-".repeat(car.getScore()));
        processString.append("\n");
    }

    protected int getMaxScore(List<Car> cars) {
        return cars.stream().map(Car::getScore)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    protected List<String> getWinners(List<Car> cars, int maxScore) {
        return cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    protected void printWinners(List<String> winner) {
        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }
}
