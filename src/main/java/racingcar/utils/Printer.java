package racingcar.utils;

import java.util.List;
import racingcar.car.model.Car;

public class Printer {

    public static void gameResultPrinter(List<Car> raceParticipants) {
        for (Car car : raceParticipants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void winnerPrinter(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winnerList));
    }
}
