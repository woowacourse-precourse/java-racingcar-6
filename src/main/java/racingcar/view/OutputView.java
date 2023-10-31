package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.utils.Constants;

import java.util.List;

public class OutputView {

    public static void showCarNameAndPosition(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + Constants.SHOW_CAR_RESULT_DELIMITER + car.resultPosition()));
        System.out.println(Constants.NEXT_LINE);
    }

    public static void finalWinnerMessage(Winner winner) {
        System.out.println(Constants.SHOW_WINNER_MESSAGE + winner.getWinnerCarNames());
    }
}
