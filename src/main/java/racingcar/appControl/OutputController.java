package racingcar.appControl;

import java.util.List;
import racingcar.play.Car;

public class OutputController {
    public static void printCarPosition(Car car) {
        System.out.println(car.toString());
    }

    public static void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}
