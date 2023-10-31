package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printRoundResult(List<Car> racedCars) {
        for (Car racedCar : racedCars) {
            System.out.println(racedCar);
        }
        System.out.println();
    }

    public static void printRaceStartMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
