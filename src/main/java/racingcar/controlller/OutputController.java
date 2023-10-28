package racingcar.controlller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

public class OutputController {
    public static void printWinnersMessage(Cars cars) {
        System.out.println(OutputView.WinnersMessage(cars));
    }

    public static void printForwardStateMessage(Cars cars) {
        System.out.println(OutputView.currentForwardStateMessage(cars));
    }

    public static void printResultHeaderMessage() {
        System.out.println(OutputView.resultHeaderMessage());
    }
}
