package racingcar.view;

import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class OutputView {
    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printString(String string) {
        System.out.println(string);
    }
}
