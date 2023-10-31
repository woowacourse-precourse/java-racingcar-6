package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private static final String COUNT_MARK = "-";

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + COUNT_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            String winnerName = winner.getName();
            winnerNames.append(winnerName);
            if (i != winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
