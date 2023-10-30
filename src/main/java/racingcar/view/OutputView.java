package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printInfo(String message) {
        System.out.print(message);
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getMoveCount(); i++) {
                resultBuilder.append('-');
            }
            System.out.println(resultBuilder);
        }
        System.out.println();
    }
}
