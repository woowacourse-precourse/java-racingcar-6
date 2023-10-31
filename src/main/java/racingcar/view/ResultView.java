package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.Delimiters.RACE_WINNER_DELIMITER;
import static racingcar.constants.ViewMessages.*;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {
        System.out.println((RACE_RESULT.getMessage()));
        for (Car car : cars) {
            System.out.println(car.getName() + EQUAL.getMessage()
                    + MOVE_FORWARD_SYMBOL.getMessage().repeat(car.getPosition()));
        }
        System.out.println();
    }

}

