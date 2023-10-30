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

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.toString().replace("[","").replace("]",""));
    }
}
