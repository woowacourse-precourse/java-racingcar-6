package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

public class OutputView {

    public static void showCarNameAndPosition(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.resultPosition()));
        System.out.println("\n");
    }

    public static void finalWinnerMessage(Winner winner) {
        System.out.println("최종 우승자 : " + winner.getWinnerCarNames());
    }
}
