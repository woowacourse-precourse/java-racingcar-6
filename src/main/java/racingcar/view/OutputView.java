package racingcar.view;

import java.util.stream.IntStream;
import racingcar.model.Cars;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printOneGameResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getDistance()).forEach(i -> System.out.print("-"));
            System.out.println();
        });
        System.out.println();
    }
}
