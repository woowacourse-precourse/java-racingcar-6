package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class RacingProcess {
    public static void showOneRound(List<Car> cars) {
        cars.stream().forEach(car -> System.out.println(car));
        System.out.println();
    }

    public static void showText() {
        System.out.println("\n실행 결과");
    }
}
