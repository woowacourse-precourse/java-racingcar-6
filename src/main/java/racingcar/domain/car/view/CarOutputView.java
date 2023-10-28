package racingcar.domain.car.view;

import racingcar.domain.car.Car;
import racingcar.domain.util.OutputMessage;

import java.util.List;

public class CarOutputView {
    public static void printEndGame() {
        System.out.print(OutputMessage.PRINT_FINAL_WINNER.getMessage());
    }

    public void printResult() {
        System.out.println(OutputMessage.PRINT_ROUND_RESULT.getMessage());
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(System.out::print);
        System.out.println();
    }
}
