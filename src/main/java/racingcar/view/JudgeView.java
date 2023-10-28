package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class JudgeView {

    public static void printWinners(List<Car> winners) {

        System.out.println("최종 우승자 : " + formatWinners(winners));
    }

    private static String formatWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return String.join(", ", winnerNames);
    }
}
