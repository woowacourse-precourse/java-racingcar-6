package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printPlayResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printPlayResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i=0; i<car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
