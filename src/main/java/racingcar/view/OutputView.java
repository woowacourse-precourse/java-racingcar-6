package racingcar.view;

import racingcar.model.Car;
import racingcar.util.Constant;
import racingcar.util.Util;

import java.util.List;

public class OutputView {

    public static void printRoundResultMessage() {
        System.out.println(Constant.OUTPUT_ROUND_RESULT_MESSAGE);

    }

    public static void printRoundResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + Constant.OUTPUT_ROUND_RESULT_DELIMITER + Util.createMarkString(car.getPosition())));
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(Constant.OUTPUT_WINNER_MESSAGE + String.join(Constant.OUTPUT_CAR_NAME_DELIMITER, winners));
    }

}
