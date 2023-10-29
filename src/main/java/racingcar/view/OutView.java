package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutView {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FORWARDING_LETTER = "-";

    public static void printExecutionStart() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    public static void printAttemptResults(List<Car> cars) {
        cars.forEach(OutView::printAttemptResult);
        System.out.println();
    }

    private static void printAttemptResult(Car car) {
        System.out.println(car.getName() + " " + FORWARDING_LETTER.repeat(car.getMoveCount()));
    }
}
