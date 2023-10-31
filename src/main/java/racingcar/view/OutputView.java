package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class OutputView {
    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners) + "가 최종 우승했습니다.";
        System.out.println(result);
    }
    public void printLineBreak() {
        System.out.println();
    }
}
