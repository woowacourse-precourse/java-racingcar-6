package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.util.OutputMessage.*;
import static racingcar.util.Utils.formatListToString;

public class OutputView {

    public void printCarDistanceAll(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(CAR_NAME.getMessage(car.getName()));
            printCarDistance(car);
        });
        System.out.println();
    }

    private void printCarDistance(Car car) {
        IntStream.range(0, car.getDistance())
                .forEach(i -> System.out.print(CAR_MOVE.getMessage()));
        System.out.println();
    }

    //formatListToString(winners)

    public void printWinner(List<String> winners) {
        System.out.print(FINAL_WINNER.getMessage(formatListToString(winners)));
    }

    public void printExecutionResult() {
        System.out.println(EXECUTION.getMessage());
    }

}
