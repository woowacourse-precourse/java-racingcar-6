package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Constants;
import racingcar.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void showCarNameAndPosition(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + Constants.SHOW_CAR_RESULT_DELIMITER + resultPosition(car)));
        System.out.println(Constants.NEXT_LINE);
    }

    public static void finalWinnerMessage(Winner winner) {
        System.out.println(Constants.SHOW_WINNER_MESSAGE + winner.getWinnerCarNames());
    }

    public static String resultPosition(Car car) {

        return IntStream.range(0, car.getPosition())
                .mapToObj(i -> Constants.DASH)
                .collect(Collectors.joining());
    }
}
