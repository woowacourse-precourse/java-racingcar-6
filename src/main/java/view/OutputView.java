package view;

import racingcar.Car;
import racingcar.RacingCars;

import java.util.List;

public class OutputView {
    public static void printRacingCars(RacingCars racingCars) {
        for (Car car : racingCars.getRacingCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(RacingCars racingCars) {
        List<String> winners = racingCars.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
