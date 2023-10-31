package racingcar.view;

import racingcar.Constants;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class JudgeView {

    public static void printWinners(List<Car> winners) {

        System.out.println(Constants.WINNER_OUTPUT + formatWinners(winners));
    }

    private static String formatWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return String.join(", ", winnerNames);
    }
}
