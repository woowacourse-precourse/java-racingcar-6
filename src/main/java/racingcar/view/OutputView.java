package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public static void printCarScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
    }

    public static void printWinners(List<String> carNames) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < carNames.size(); i++) {
            if (i >= 1) {
                System.out.print(", ");
            }
            System.out.print(carNames.get(i));
        }
        System.out.println();
    }

    public static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
