package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    public static void carStatusMessage(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName()
                    + " : " + "-".repeat(car.getMoveStatus()));
        }
        System.out.println();
    }

    public static void winnerMessage(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
