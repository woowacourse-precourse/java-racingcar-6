package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void exeutionResult() {
        System.out.println("실행 결과");
    }

    public static void resultGame(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
