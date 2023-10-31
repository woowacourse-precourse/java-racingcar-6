package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    public static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getPositionBar());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String message = "최종 우승자: " + String.join(", ", winners);
        System.out.println(message);
    }
}
