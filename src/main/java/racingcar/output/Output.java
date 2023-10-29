package racingcar.output;

import racingcar.domain.RacingCar;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Output {
    private static void print(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printResult() {
        print(OutputMessage.RESULT);
    }

    public static void printWinner() {
        print(OutputMessage.WINNER);
        System.out.println(String.join(", ", getWinner()));
    }

    private static List<String> getWinner() {
        List<Car> cars = RacingCar.getCars();
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoves() == getMaxMoves(cars)) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private static int getMaxMoves(List<Car> cars) {
        int maxMoves = 0;
        for (Car car : cars) {
            maxMoves = max(maxMoves, car.getMoves());
        }
        return maxMoves;
    }

    public static void printRoundResult() {
        List<Car> cars = RacingCar.getCars();
        for (Car car : cars) {
            printCarMoves(car);
        }
        System.out.println();
    }

    private static void printCarMoves(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMoves(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
