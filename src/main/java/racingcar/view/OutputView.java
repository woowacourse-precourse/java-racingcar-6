package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String MOVE_EXP = "-";
    private OutputView() {
    }

    public static void writeResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void writePlayResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + MOVE_EXP.repeat(car.getMoveCount())));
        System.out.println();
    }
}
