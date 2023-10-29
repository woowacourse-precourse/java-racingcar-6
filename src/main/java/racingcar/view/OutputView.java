package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), car.getStringLocation());
        }
        System.out.println();
    }

    public static void printFinalWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + winnersNameStringBuilder(winners));
    }

    private static String winnersNameStringBuilder(List<String> winners) {
        StringBuilder builder = new StringBuilder();
        for (String winner : winners) {
            builder.append(winner);
            if (winners.indexOf(winner) < winners.size() - 1) {
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
