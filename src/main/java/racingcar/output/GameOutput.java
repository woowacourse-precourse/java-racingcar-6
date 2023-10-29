package racingcar.output;

import java.util.List;
import racingcar.domain.Car;

public class GameOutput {

    public static void initializeOutput() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
