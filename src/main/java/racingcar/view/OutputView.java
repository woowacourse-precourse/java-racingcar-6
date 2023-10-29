package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceResult(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }
}
