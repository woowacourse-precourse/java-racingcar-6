package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public final List<Cars> cars;

    public ResultView(List<Cars> cars) {
        this.cars = cars;
    }
    public  void printRace(List<Cars> cars) {
        for (Cars car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Cars> winners) {
        String winnerNames = winners.stream()
                .map(Cars::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
