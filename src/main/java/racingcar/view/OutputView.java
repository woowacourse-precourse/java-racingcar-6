package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printRoundResult(List<Car> cars) {
        for (Car c: cars) {
            System.out.println(c.convertPositionToString());
        }
        System.out.print("\n");
    }
}
