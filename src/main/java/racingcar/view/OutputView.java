package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.util.Constants;

public class OutputView {
    public static void printCarResult(List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

    public static void printResultConstant() {
        System.out.println();
        System.out.println(Constants.RESULT_CONSTANT.constant);
    }

    public static void printWinnerList(List<Car> winCars) {
        String winners = winCars.stream()
                .map(Car::name)
                .collect(Collectors.joining(Constants.WINNER_SPLIT_FORMAT.constant));

        System.out.println(Constants.WINNER_RESULT.constant
                            + Constants.OUTPUT_FORMAT.constant
                            + winners);
    }
}
