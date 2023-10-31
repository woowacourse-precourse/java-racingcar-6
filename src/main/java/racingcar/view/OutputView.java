package racingcar.view;

import static racingcar.util.Message.MOVE_RESULT;
import static racingcar.util.Message.OUTPUT_PLAY_RESULT;
import static racingcar.util.Message.OUTPUT_WINNER;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {

    public static void printMessage() {
        System.out.println(OUTPUT_PLAY_RESULT);
    }

    public static void printPlayResult(List<Cars> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            int distance = car.getDistance();
            System.out.println(MOVE_RESULT.repeat(distance));
        });
        System.out.println();
    }

    public static void printWinner(List<String> result) {
        String winner = String.join(",", result);

        System.out.println(OUTPUT_WINNER + " : " + winner);
    }
}
