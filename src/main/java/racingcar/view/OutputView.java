package racingcar.view;

import static racingcar.view.constants.Notice.RESULT;
import static racingcar.view.constants.Notice.WINNER;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printResult(Car car) {
        String result = "";
        for (int i = 0; i < car.getDistance(); i++) {
            result += "-";
        }
        System.out.println(car.getName() + " : " + result);
    }

    public static void printWinner(List<String> winners) {
        System.out.print(WINNER);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
