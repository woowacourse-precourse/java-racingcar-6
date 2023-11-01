package racingcar.view;

import racingcar.constant.Message;
import racingcar.model.Car;

public class Output {

    public static void printRunResultMessage() {
        System.out.println(Message.RUN_RESULT);
    }

    public static void printRunResult(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionStatus());
    }

    public static void printBlankLine() {
        System.out.println();
    }

}
