package racingcar.view;

import racingcar.domain.Car;
import racingcar.message.ProcessMessage;

import java.util.List;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(ProcessMessage.INPUT_NAME);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(ProcessMessage.INPUT_ATTEMPT_COUNT);
    }

    public void printMoveRecords(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
