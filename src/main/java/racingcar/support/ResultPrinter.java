package racingcar.support;

import racingcar.game.components.Car;

import java.util.List;
import java.util.StringJoiner;

import static racingcar.message.GameMessages.RESULT_MARKER;
import static racingcar.message.GameMessages.WINNERS;

public class ResultPrinter {

    public void execute(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int counter = 0; counter < car.getDistance(); counter++) {
                System.out.print(RESULT_MARKER);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void winner(List<Car> winners) {
        System.out.print(WINNERS);
        StringJoiner result = new StringJoiner(", ");
        for (Car winner : winners) {
            result.add(winner.getName());
        }
        System.out.println(result);
    }
}
