package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.constant.Constant;
import racingcar.utils.constant.Message;

public class OutputView {
    public static void printOutputMessage() {
        System.out.println(Message.OUTPUT_MESSAGE);
    }

    public static void printLocation(Car car) {
        System.out.print(car.getName() + Constant.RESULT_DELIMITER);
        System.out.println(Constant.CAR_LOCATION.repeat(car.getMoveCount()));
    }
}
