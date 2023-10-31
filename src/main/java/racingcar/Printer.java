package racingcar;

import java.util.List;

public class Printer {
    public static void gameResultPrinter(List<Car> raceParticipants) {
        for (Car car : raceParticipants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
    public static void winnerPrinter(List<String> winnerList) {
        //TODO 쉼표 구분
        System.out.print("최종 우승자는 ");
        for (String winner : winnerList) {
            System.out.print(winner + " ");
        }
    }
}
