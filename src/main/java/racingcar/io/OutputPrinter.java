package racingcar.io;

import java.util.List;
import racingcar.domain.Car;

public class OutputPrinter {
    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTriesPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
