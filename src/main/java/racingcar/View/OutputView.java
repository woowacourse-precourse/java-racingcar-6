package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfAttemptsMessage() { System.out.println("시도할 회수는 몇회인가요?"); }

    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printExecutionMessage(List<Car> cars) {
        for (var car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    public static void printWinnerMessage(List<String> winners) {
        System.out.print("최종 우승자 :" + String.join(", ", winners));
    }
}
