package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;

public class OutputView {

    public static void printResult(List<Car> cars) {
        StringJoiner result = new StringJoiner("\n");
        for (Car car : cars) {
            result.add(String.format("%s : %s", car.getName(), car.getStringLocation()));
        }
        System.out.println(result);
    }

    public static void printFinalWinner(List<String> winners) {
        String winnersString = String.join(",", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}
