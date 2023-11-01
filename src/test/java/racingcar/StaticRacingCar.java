package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class StaticRacingCar {
    static class User {
        public static String[] carNames() {
            return new String[]{"A", "B", "C"};
        }

        public static String racingRound() {
            return "3";
        }
    }

    static class NumberGenerator {
        public static int generateNumber() {
            return 4;
        }

    }
    static String eachRoundResult(List<Car> racingCarList) {
        StringBuilder result = new StringBuilder();

        for (Car car : racingCarList) {
            result.append(car.getCarName()).append(" : ");
            result.append("-".repeat(Math.max(0, car.getCurrentPosition())));
            result.append("\n");
        }
        return result.toString();
    }
    static int findMaxDistance(List<Car> racingCarsList) {
        return racingCarsList.stream()
                .max(Comparator.comparingInt(Car::getCurrentPosition))
                .map(Car::getCurrentPosition)
                .orElse(0);
    }
    static List<Car> decideWinner(List<Car> racingCarsList) {
        int winnerDistance = findMaxDistance(racingCarsList);

        return racingCarsList.stream()
                .filter(car ->car.getCurrentPosition() == winnerDistance)
                .collect(Collectors.toList());
    }

    static String[] toArrayWinner(List<Car> winner) {
        return winner.stream()
                .map(car -> car.getCarName())
                .toArray(String[]::new);
    }
}
