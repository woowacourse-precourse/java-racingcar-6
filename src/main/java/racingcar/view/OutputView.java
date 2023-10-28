package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.constant.Constant;
import racingcar.utils.constant.Message;

public class OutputView {
    public static void printOutputMessage() {
        System.out.println(Message.OUTPUT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        cars.forEach(OutputView::printLocation);
        System.out.println();
    }

    private static void printLocation(Car car) {
        System.out.print(car.getName() + Constant.RESULT_DELIMITER);
        System.out.println(Constant.CAR_LOCATION.repeat(car.getMoveCount()));
    }

    public static void printWinners(List<String> names) {
        System.out.println(Message.FINAL_WINNERS + String.join(Constant.WINNER_DELIMITER, names));

    }
}
