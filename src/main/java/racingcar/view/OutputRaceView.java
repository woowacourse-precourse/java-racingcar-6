package racingcar.view;

import java.util.List;

public class OutputRaceView {
    public static void printRaceResult(List<Car> cars) {
        System.out.println("\n실행 결과");
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
    }
}
